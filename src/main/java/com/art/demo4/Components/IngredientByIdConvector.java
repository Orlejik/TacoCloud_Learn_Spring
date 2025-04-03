package com.art.demo4.Components;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Repositories.Interfaces.IngredientRepository;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConvector implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;
    private final TestIngredientRepository testIngredientRepository;
    private String ingredientShortName;

    public IngredientByIdConvector(IngredientRepository ingredientRepository, TestIngredientRepository testIngredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.testIngredientRepository = testIngredientRepository;
    }
    @Override
    public Ingredient convert(String ingredientShortName) {
        this.ingredientShortName = ingredientShortName;
        return testIngredientRepository.findByIngredientShortName(ingredientShortName);
    }
}
