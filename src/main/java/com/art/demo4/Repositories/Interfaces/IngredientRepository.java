package com.art.demo4.Repositories.Interfaces;

import com.art.demo4.Data.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
//    Optional<Ingredient> findById(Long id);
    Ingredient save(Ingredient ingredient);
    List<Ingredient> findByIngredientShortName(String ingredientShortName);
}