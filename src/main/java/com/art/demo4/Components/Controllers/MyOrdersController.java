package com.art.demo4.Components.Controllers;

import com.art.demo4.Data.TacoOrder;
import com.art.demo4.Data.User;
import com.art.demo4.Repositories.TestRepos.TestOrderRepository;
import com.art.demo4.Repositories.TestRepos.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/my")
public class MyOrdersController {
    private final TestOrderRepository orderRepository;
    private final UserRepository userRepository;

    public MyOrdersController(TestOrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/orders")
    public String orders(Model model, @AuthenticationPrincipal User user) {
        List<TacoOrder> myOrders = orderRepository.findAllByUser(user);
        Optional<User> currentUser = userRepository.findById(user.getId());
        model.addAttribute("myOrders", myOrders);
        model.addAttribute("currentUserGetFullName", currentUser.get().getFullName());
        return "myOrders";
    }
}
