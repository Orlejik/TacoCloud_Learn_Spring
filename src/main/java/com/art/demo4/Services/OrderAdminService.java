package com.art.demo4.Services;

import com.art.demo4.Repositories.TestRepos.TestOrderRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class OrderAdminService {
    private final TestOrderRepository testOrderRepository;

    public OrderAdminService(TestOrderRepository testOrderRepository) {
        this.testOrderRepository = testOrderRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders(){
        testOrderRepository.deleteAll();
    }
}
