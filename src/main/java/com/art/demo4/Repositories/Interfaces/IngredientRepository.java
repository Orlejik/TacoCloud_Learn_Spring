package com.art.demo4.Repositories.Interfaces;

import com.art.demo4.Data.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAll();
    Optional<Ingredient> findById(Long id);
    Ingredient save(Ingredient ingredient);
}
