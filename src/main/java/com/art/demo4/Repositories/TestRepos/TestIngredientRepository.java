package com.art.demo4.Repositories.TestRepos;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Data.IngredientTypes;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestIngredientRepository extends JpaRepository<Ingredient, Long> {
    public List<Ingredient> findAll();
    public List<Ingredient> findAllByType_TypeName(String typeName);
    public Ingredient findByIngredientShortName(String ingredientShortName);

}