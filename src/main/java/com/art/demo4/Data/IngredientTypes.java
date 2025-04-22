package com.art.demo4.Data;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String typeName;

        public IngredientTypes(@NonNull String typeName) {
            this.typeName = typeName;
    }

}