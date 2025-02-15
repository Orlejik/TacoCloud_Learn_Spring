//package com.art.demo4.Repositories;
//
//import com.art.demo4.Data.Ingredient;
//import com.art.demo4.Repositories.Interfaces.IngredientRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Optional;
//
//@Repository
//public class JdbcIngredientRepository implements JpaRepository<Ingredient,Long>{
//
//}
//public class JdbcIngredientRepository implements IngredientRepository {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Iterable<Ingredient> findAll() {
//        return jdbcTemplate.query("select id, name, type from Ingredient", this::mapRowToIngredient);
//    }
//
//    @Override
//    public Optional<Ingredient> findById(String id) {
//        return Optional.ofNullable(jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?",
//                new RowMapper<Ingredient>() {
//                    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        return new Ingredient(
//                                rs.getString("id"),
//                                rs.getString("name"),
//                                Ingredient.Type.valueOf(rs.getString("type")));
//                    }
//                }, id));
//    }
//
//
//    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
//        return new Ingredient(
//                row.getString("id"),
//                row.getString("name"),
//                Ingredient.Type.valueOf(row.getString("type"))
//        );
//    }
//
//
//    @Override
//    public Ingredient save(Ingredient ingredient) {
//        jdbcTemplate.update(
//                "insert into  Ingredient (id, name, type) values (?, ?,?)",
//                ingredient.getId(), ingredient.getName(), ingredient.getType().toString()
//        );
//        return ingredient;
//    }
//}
