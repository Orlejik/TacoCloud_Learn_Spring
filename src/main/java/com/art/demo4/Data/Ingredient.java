package com.art.demo4.Data;


import com.art.demo4.Repositories.TestRepos.TypesRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Data
@Entity
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@NoArgsConstructor
//@RequiredArgsConstructor
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

    public Ingredient(@NonNull String ingredientShortName, @NonNull String name, IngredientTypes type) {
        this.ingredientShortName = ingredientShortName;
        this.ingredientName = name;
        this.type = type;
    }

//    public Ingredient() {
//
//    }

}
