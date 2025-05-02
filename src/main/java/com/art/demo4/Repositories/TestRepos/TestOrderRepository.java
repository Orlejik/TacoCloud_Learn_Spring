package com.art.demo4.Repositories.TestRepos;

import com.art.demo4.Data.TacoOrder;
import com.art.demo4.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestOrderRepository extends CrudRepository<TacoOrder, Long> {

    void deleteById(Long id);
    TacoOrder save(TacoOrder tacoOrder);

    public List<TacoOrder> findAllByUser(User user);
}
