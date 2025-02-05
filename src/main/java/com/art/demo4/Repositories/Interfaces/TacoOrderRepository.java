package com.art.demo4.Repositories.Interfaces;

import com.art.demo4.Data.Taco;
import com.art.demo4.Data.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TacoOrderRepository extends JpaRepository<TacoOrder, Long> {
    TacoOrder findByTacos(Taco taco);
}
