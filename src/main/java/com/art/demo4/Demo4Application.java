package com.art.demo4;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Data.IngredientTypes;
import com.art.demo4.Data.User;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import com.art.demo4.Repositories.TestRepos.TypesRepository;
import com.art.demo4.Repositories.TestRepos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@EnableJpaRepositories(basePackages = "com.art.demo4.Repositories.TestRepos")
@SpringBootApplication

public class Demo4Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }

}