package com.art.demo4.Components;

import com.art.demo4.Data.*;
import com.art.demo4.Repositories.TestRepos.TestIngredientRepository;
import com.art.demo4.Repositories.TestRepos.TestTacoRepository;
import com.art.demo4.Repositories.TestRepos.TypesRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    Logger log = LoggerFactory.getLogger(DesignTacoController.class);
    private final TypesRepository typesRepository;
    private final TestIngredientRepository testIngredientRepository;
    private final TestTacoRepository testTacoRepository;

    @Autowired
    public DesignTacoController(TypesRepository typesRepository, TestIngredientRepository testIngredientRepository, TestTacoRepository testTacoRepository) {
        this.typesRepository = typesRepository;
        this.testIngredientRepository = testIngredientRepository;
        this.testTacoRepository = testTacoRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = testIngredientRepository.findAll();
        List<IngredientTypes> types = typesRepository.findAll();
        model.addAttribute("types", types);
        Map<String, List<Ingredient>> ingredientsByTypeMap = new HashMap<>();
        for (IngredientTypes type : types) {
            List<Ingredient> ingredientsByType = testIngredientRepository.findAllByType_TypeName(type.getTypeName())
                    .stream()
                    .sorted(Comparator.comparing(Ingredient::getIngredientName))
                    .collect(Collectors.toList());
            ingredientsByTypeMap.put(type.getTypeName(), ingredientsByType);
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type.getTypeName()));

        }
        model.addAttribute("ingredientsByTypeMap", ingredientsByTypeMap);
    }

    @GetMapping
    public String showDesignedForm(@ModelAttribute Taco designedTaco, Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        System.out.println(user.getAuthorities());
        String url = "http:localhost:8081/design";
        System.out.println("Access URL: "+url);
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, String typeName) {
        return ingredients.stream().filter(x -> x.getType().getTypeName().equals(typeName)).collect(Collectors.toList());
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }


    @PostMapping
    public String processTaco(@Valid Taco taco, Errors error,
                              @ModelAttribute TacoOrder tacoOrder, Model model, SessionStatus status) {
        log.info("Processing taco : " + taco);
        if (error.hasErrors()) {
            model.addAttribute("error", error.getAllErrors());
            String url = "http:localhost:8081/design?error";
            System.out.println("Access URL: "+url);
            return "design";
        }
        Taco newTaco = new Taco();
        newTaco.setName(taco.getName());
        newTaco.setIngredients(taco.getIngredients());
        newTaco.setCreatedAt(taco.getCreatedAt());
        tacoOrder.addTaco(newTaco);
        testTacoRepository.save(newTaco);
        log.info("Processing taco Order : " + tacoOrder);
        String url = "http:localhost:8081/orders/current";
        System.out.println("Access URL: "+url);
        return "redirect:/orders/current";
    }

}
