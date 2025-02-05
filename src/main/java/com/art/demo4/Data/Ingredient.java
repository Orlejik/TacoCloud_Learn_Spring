package com.art.demo4.Data;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.art.demo4.Data.Enums.TypeEnum;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredient_id;
    @NotNull(message = "Name of taco should not be empty")
    private String name;
    @NotNull(message = "check at least one option")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "taco_id")
    private Taco taco;

//    public Ingredient(String id, String name, Type type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }

    public Long getId() {
        return ingredient_id;
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
