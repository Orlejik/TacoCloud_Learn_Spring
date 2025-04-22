package com.art.demo4.Repositories.TestRepos;

import com.art.demo4.Data.IngredientTypes;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypesRepository extends CrudRepository<IngredientTypes, Long> {
    
    public @NonNull List<IngredientTypes> findAll();

}
