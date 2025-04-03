package com.art.demo4.Data;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String ingredientShortName;
    @NotNull
    private String ingredientName;

    @ManyToOne
    private IngredientTypes type;

    public Ingredient(String id, String name, String typeId) {
    }
}
