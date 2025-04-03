package com.art.demo4.Repositories.TestRepos;

import com.art.demo4.Data.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestTacoRepository extends JpaRepository<Taco, Long> {
//    public Taco save(Taco taco);
//    public List<Taco> findAllByOrderId(Long orderId);
}
