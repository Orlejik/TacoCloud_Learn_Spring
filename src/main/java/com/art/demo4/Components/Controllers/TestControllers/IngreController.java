package com.art.demo4.Components.Controllers.TestControllers;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/")
@RestController
@AllArgsConstructor
public class IngreController {

    private final TestIngredientRepository ingredientRepository;

    @GetMapping("ingredients/all")
    public List<Ingredient> findAllIngredients(){
        return ingredientRepository.findAll();
    }

}