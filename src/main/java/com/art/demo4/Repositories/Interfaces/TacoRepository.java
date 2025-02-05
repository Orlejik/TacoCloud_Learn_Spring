package com.art.demo4.Repositories.Interfaces;

import com.art.demo4.Data.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
    List<Taco> findAll();
    Taco save(Taco taco);
    Taco getById(Long id);
}
