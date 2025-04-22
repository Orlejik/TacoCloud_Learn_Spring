package com.art.demo4.Repositories.TestRepos;

import com.art.demo4.Data.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestOrderRepository extends CrudRepository<TacoOrder, Long> {

    void deleteById(Long id);
    TacoOrder save(TacoOrder tacoOrder);
}
