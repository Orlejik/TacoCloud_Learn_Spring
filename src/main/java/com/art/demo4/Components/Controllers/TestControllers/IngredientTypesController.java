package com.art.demo4.Components.Controllers.TestControllers;

import com.art.demo4.Data.IngredientTypes;
import com.art.demo4.Repositories.TestRepos.TypesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class IngredientTypesController {
    private final TypesRepository typesRepository;

    @GetMapping("/ingr-types/all")
    public List<IngredientTypes> findAllIngredientTypes(){
        return typesRepository.findAll();
    }
}
