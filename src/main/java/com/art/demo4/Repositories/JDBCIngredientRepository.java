package com.art.demo4.Repositories;

import com.art.demo4.Data.Ingredient;
import com.art.demo4.Data.IngredientTypes;
import com.art.demo4.Repositories.Interfaces.IngredientRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JDBCIngredientRepository implements IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    public JDBCIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
//        return jdbcTemplate.query(
//                "select id, name, type_id from Ingredient", this::mapRowToIngredient
//        );
    }

//    @Override
//    public Optional<Ingredient> findById(Long id) {
////        List<Ingredient> result = jdbcTemplate.query(
////                "select id, name, type_id from Ingredient where id=?", this::mapRowToIngredient, id
////        );
////        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
//        return null;
//    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredient (id, ingredientName, type_id) values (?, ?, ?)",
//                ingredient.getId(),
                ingredient.getIngredientName()
//                ingredient.getType().toString()
        );

        return ingredient;
    }

    @Override
    public List<Ingredient> findByIngredientShortName(String ingredientShortName) {
        jdbcTemplate.query("select id, ingredeintName, ingredientShortName, type from Ingredient where ingredientShortName=?", this::mapRowToIngredient, ingredientShortName);
        return List.of();
    }


    public void delete(Ingredient ingredient) {
//        jdbcTemplate.update(
//                "delete from Ingredient where id=?",
//                ingredient.getId()
//        );
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                row.getString("type_id")
        );
    }
}
