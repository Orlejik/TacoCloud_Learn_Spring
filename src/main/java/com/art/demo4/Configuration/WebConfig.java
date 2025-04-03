package com.art.demo4.Configuration;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Data.Taco;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

//    @Bean
//    public CommandLineRunner dataLoader(
//            IngredientRepository ingredientRepo,
//            UserRepository userRepo,
//            PasswordEncoder encoder,
//            TacoRepository tacoRepo,
//            BeanFactoryPostProcessor forceAutoProxyCreatorToUseClassProxying) {
//        return args -> {
//            Ingredient flourTortilla = new Ingredient(
//                    "FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
//            Ingredient cornTortilla = new Ingredient(
//                    "COTO", "Corn Tortilla", Ingredient.Type.WRAP);
//            Ingredient groundBeef = new Ingredient(
//                    "GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
//            Ingredient carnitas = new Ingredient(
//                    "CARN", "Carnitas", Ingredient.Type.PROTEIN);
//
//            Ingredient tomatoes = new Ingredient(
//                    "TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
//            Ingredient lettuce = new Ingredient(
//                    "LETC", "Lettuce", Ingredient.Type.VEGGIES);
//            Ingredient cheddar = new Ingredient(
//                    "CHED", "Cheddar", Ingredient.Type.CHEESE);
//            Ingredient jack = new Ingredient(
//                    "JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
//            Ingredient salsa = new Ingredient(
//                    "SLSA", "Salsa", Ingredient.Type.SAUCE);
//            Ingredient sourCream = new Ingredient(
//                    "SRCR", "Sour Cream", Ingredient.Type.SAUCE);
//
//            ingredientRepo.save(flourTortilla);
//            ingredientRepo.save(cornTortilla);
//            ingredientRepo.save(groundBeef);
//            ingredientRepo.save(carnitas);
//            ingredientRepo.save(tomatoes);
//            ingredientRepo.save(lettuce);
//            ingredientRepo.save(cheddar);
//            ingredientRepo.save(jack);
//            ingredientRepo.save(salsa);
//            ingredientRepo.save(sourCream);
//
//            Taco taco1 = new Taco();
//            taco1.setName("Taco1");
//            taco1.setIngredients(
//                    Arrays.asList(
//                            flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
//            tacoRepo.save(taco1);
//
//            Taco taco2 = new Taco();
//            taco1.setName("Taco1");
//            taco1.setIngredients(
//                    Arrays.asList(
//                            cornTortilla, groundBeef, cheddar, jack, salsa));
//            tacoRepo.save(taco2);
//
//            Taco taco3 = new Taco();
//            taco1.setName("Taco1");
//            taco1.setIngredients(
//                    Arrays.asList(
//                            flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
//            tacoRepo.save(taco3);
//
//        };
//    }
}
