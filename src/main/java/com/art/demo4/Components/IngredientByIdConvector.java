package com.art.demo4.Components;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Repositories.Interfaces.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConvector implements Converter<Long, Ingredient> {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConvector(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
