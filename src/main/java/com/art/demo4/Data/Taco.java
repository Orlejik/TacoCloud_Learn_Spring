package com.art.demo4.Data;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "taco_id")
    private Long id;

    @NotNull
    @Size(min = 5, max = 10, message = "Name must be at least 5 and maximum 10 characters")
    private String name;
    @NotNull
    @Size(min = 1, message = "You should check at least one ingredient...")
    @OneToMany(mappedBy = "ingredient_id")
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "taco_order")
    private TacoOrder tacoOrder;

    private Date createDate = new Date();

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
