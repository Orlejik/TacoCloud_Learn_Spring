package com.art.demo4;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Data.IngredientTypes;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import com.art.demo4.Repositories.TestRepos.TypesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo4Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }


    @Bean
    public CommandLineRunner dataLoader(TestIngredientRepository ingrRepo, TypesRepository typeRepo) {
        return args -> {
            typeRepo.save(new IngredientTypes("WRAP"));
            typeRepo.save(new IngredientTypes("PROTEIN"));
            typeRepo.save(new IngredientTypes("VEGGIES"));
            typeRepo.save(new IngredientTypes("CHEESE"));
            typeRepo.save(new IngredientTypes("SAUCE"));

            IngredientTypes wrapType = typeRepo.findById(1L).orElseThrow(()->new RuntimeException("Types not found"));
            IngredientTypes proteinType = typeRepo.findById(2L).orElseThrow(()->new RuntimeException("Types not found"));
            IngredientTypes veggiesType = typeRepo.findById(3L).orElseThrow(()->new RuntimeException("Types not found"));
            IngredientTypes cheesType = typeRepo.findById(4L).orElseThrow(()->new RuntimeException("Types not found"));
            IngredientTypes souceType = typeRepo.findById(5L).orElseThrow(()->new RuntimeException("Types not found"));

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
}
