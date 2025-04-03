package com.art.demo4.Repositories.TestRepos;

import com.art.demo4.Data.IngredientTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypesRepository extends JpaRepository<IngredientTypes, Integer> {
    
    public List<IngredientTypes> findAll();

}
