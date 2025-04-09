package com.art.demo4.Components;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConvector implements Converter<String, Ingredient> {

    @Autowired
    private final TestIngredientRepository testIngredientRepository;

    public IngredientByIdConvector(TestIngredientRepository ingredientRepository, TestIngredientRepository testIngredientRepository) {
        this.testIngredientRepository = testIngredientRepository;
    }
    @Override
    public Ingredient convert(@NonNull String ingredientShortName) {
        return testIngredientRepository.findByIngredientShortName(ingredientShortName);
    }
}
