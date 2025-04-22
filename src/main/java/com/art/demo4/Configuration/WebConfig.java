package com.art.demo4.Configuration;


import com.art.demo4.Data.Ingredient;
import com.art.demo4.Data.IngredientTypes;
import com.art.demo4.Data.User;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import com.art.demo4.Repositories.TestRepos.TypesRepository;
import com.art.demo4.Repositories.TestRepos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@Configuration(proxyBeanMethods = true)
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

    @Bean
    public CommandLineRunner dataLoader(TestIngredientRepository ingrRepo, TypesRepository typeRepo) {
        return args -> {
            typeRepo.save(new IngredientTypes("WRAP"));
            typeRepo.save(new IngredientTypes("PROTEIN"));
            typeRepo.save(new IngredientTypes("VEGGIES"));
            typeRepo.save(new IngredientTypes("CHEESE"));
            typeRepo.save(new IngredientTypes("SAUCE"));

            IngredientTypes wrapType = typeRepo.findById(1L).orElseThrow(() -> new RuntimeException("Types not found"));
            IngredientTypes proteinType = typeRepo.findById(2L).orElseThrow(() -> new RuntimeException("Types not found"));
            IngredientTypes veggiesType = typeRepo.findById(3L).orElseThrow(() -> new RuntimeException("Types not found"));
            IngredientTypes cheesType = typeRepo.findById(4L).orElseThrow(() -> new RuntimeException("Types not found"));
            IngredientTypes souceType = typeRepo.findById(5L).orElseThrow(() -> new RuntimeException("Types not found"));

            ingrRepo.save(new Ingredient("FLTO", "Flour Tortilla", wrapType));
            ingrRepo.save(new Ingredient("COTO", "Corn Tortilla", wrapType));
            ingrRepo.save(new Ingredient("GRBF", "Ground Beef", proteinType));
            ingrRepo.save(new Ingredient("CARN", "Carnitas", proteinType));
            ingrRepo.save(new Ingredient("TMTO", "Diced Tomatoes", veggiesType));
            ingrRepo.save(new Ingredient("LETC", "Lettucea", veggiesType));
            ingrRepo.save(new Ingredient("CHED", "Cheddar", cheesType));
            ingrRepo.save(new Ingredient("JACK", "Monterrey Jack", cheesType));
            ingrRepo.save(new Ingredient("SLSA", "Salsa", souceType));
            ingrRepo.save(new Ingredient("SRCR", "Sour Cream", souceType));
        };
    }

    List<User> getAllUsers(UserRepository userRepo) {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;

    }

    @Bean
    @Primary
    public UserDetailsService userDetailsService(UserRepository userRepository, PasswordEncoder encoder, PasswordEncoder passwordEncoder) {
        List<User> usersInDb = getAllUsers(userRepository);
        for (User user : usersInDb) {
            System.out.println("=======================================================================================================");
            System.out.println(user);
            System.out.println(usersInDb.size());
            System.out.println(user.getUsername());
            System.out.println(encoder.encode(user.getPassword()));
            System.out.println("=======================================================================================================");
        }

//        if (!usersInDb.isEmpty()) {
            return username -> {
                User user = userRepository.findByUsername(username);
                System.out.println("============= Trying to get user from DB: " + username + " ====================================");

                if (user == null) {
                    throw new UsernameNotFoundException("User " + username + " not found");
                }
                return user;
            };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserRepository userRepository) throws Exception {
        ClearRequestCacheLogoutHandler clearRequestCache = new ClearRequestCacheLogoutHandler(http.getSharedObject(RequestCache.class));
        CookieClearingLogoutHandler cookies = new CookieClearingLogoutHandler("our-custom-cookies");
        for (User user : getAllUsers(userRepository)) {
            System.out.println(user.getUsername() + " " + user.getPassword());
        }
        return http
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/design", "/orders", "orders/current", "/orders/complete").hasRole("USER")
                                .requestMatchers("/", "/**", "/access-denied", "/api/users/all").permitAll())
                .oauth2Login((login) -> login
                        .loginPage("/login")
                        .userInfoEndpoint((userInfo) -> userInfo
                                .userAuthoritiesMapper(authorities -> {
                                            Set<GrantedAuthority> grantedAuthorities = new HashSet<>(authorities);
                                            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                                            return grantedAuthorities;
                                        }
                                )))
                .formLogin((loginForm) ->
                        loginForm
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticate")
                                .usernameParameter("user")
                                .passwordParameter("pwd")
                                .defaultSuccessUrl("/design", true)
                                .failureHandler(customFailureHandler())
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/access-denied"))
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .addLogoutHandler(cookies)
                        .addLogoutHandler(clearRequestCache)  // Add the custom cache clearing handler
                        .deleteCookies("cookies")
                        .permitAll())
                .build();
    }

    @Bean
    public AuthenticationFailureHandler customFailureHandler() {
        return (request, response, authException) -> {
            request.getSession().setAttribute("error", authException.getMessage());
            response.sendRedirect("/login?error");
        };
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
        System.out.println(builder);
        return builder.build();
    }

    @Bean
    public CommandLineRunner createDefaultAdminUser(UserRepository repo, PasswordEncoder encoder){
        return args -> {
            if(repo.count()==0){
                System.out.println("Creating default admin user");
                User user = new User(
                        "buzz",
                        encoder.encode("P@ssw0rd"),
                        "Admin User",
                        "admin@example.com",
                        "+123456789",
                        "Admin Street",
                        "Admin City",
                        "Admin State",
                        "12345"
                );
                repo.save(user);
                System.out.println("Created default admin user");
            }
        };

    }
}
