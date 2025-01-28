package com.art.demo4.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Taco {
    @NotNull
    @Size(min = 5, max = 10, message = "Name must be at least 5 and maximum 10 characters")
    private String name;
    @NotNull
    @Size(min = 1, message = "You should check at least one ingredient...")
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
