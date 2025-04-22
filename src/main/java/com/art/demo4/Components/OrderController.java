package com.art.demo4.Components;

import com.art.demo4.Repositories.TestRepos.TestTacoRepository;
import org.springframework.ui.Model;
import com.art.demo4.Data.TacoOrder;
import com.art.demo4.Repositories.TestRepos.TestOrderRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    Logger log = LoggerFactory.getLogger(OrderController.class);

    private final TestOrderRepository testOrderRepository;
    private final TestTacoRepository testTacoRepository;

    public OrderController(TestOrderRepository testOrderRepository, TestTacoRepository testTacoRepository) {
        this.testOrderRepository = testOrderRepository;
        this.testTacoRepository = testTacoRepository;
    }

    @GetMapping("/current")
    public String orderForm(){
        log.info("orderForm was requested");
        return "orderForm";
    }

    @GetMapping("/complete")
    public String completeOrder(SessionStatus status, Model model){
        model.addAttribute("status", status);
        return "complete";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Model model, Errors error, SessionStatus status){

        log.info("Order Submitted : "+order);

        if(error.hasErrors()){
            return "orderForm";
        }

        TacoOrder newOrder = new TacoOrder();
        newOrder.setId(order.getId());
        newOrder.setDeliveryName(order.getDeliveryName());
        newOrder.setDeliveryStreet(order.getDeliveryStreet());
        newOrder.setDeliveryCity(order.getDeliveryCity());
        newOrder.setDeliveryState(order.getDeliveryState());
        newOrder.setDeliveryZip(order.getDeliveryZip());
        newOrder.setCcNumber(order.getCcNumber());
        newOrder.setCcExpiration(order.getCcExpiration());
        newOrder.setCcCVV(order.getCcCVV());
        newOrder.setPlacedAt(order.getPlacedAt());
//        newOrder.setTacos(testTacoRepository.findAllByOrderId(order.getId()));
        newOrder.setTacos(order.getTacos().stream().toList());


        testOrderRepository.save(newOrder);
        status.setComplete();

        model.addAttribute("status", status);

        return completeOrder(status, model);
    }

}