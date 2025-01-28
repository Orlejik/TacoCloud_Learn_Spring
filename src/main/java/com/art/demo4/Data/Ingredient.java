package com.art.demo4.Data;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.art.demo4.Data.Enums.TypeEnum;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Ingredient {

    private final String id;
    @NotNull(message = "Name of taco should not be empty")
    private final String name;
    @NotNull(message = "check at least one option")
    private final Type type;

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
