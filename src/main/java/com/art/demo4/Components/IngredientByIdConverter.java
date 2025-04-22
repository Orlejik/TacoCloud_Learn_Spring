package com.art.demo4.Components;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IngredientByIdConverter implements Converter<Long, Optional<Ingredient>> {

    private final TestIngredientRepository testIngredientRepository;

    public IngredientByIdConverter(TestIngredientRepository testIngredientRepository) {
        this.testIngredientRepository = testIngredientRepository;
    }
    @Override
    public Optional<Ingredient> convert(@NonNull Long ingredientShortName) {
        return testIngredientRepository.findById(ingredientShortName);
    }
}
//132