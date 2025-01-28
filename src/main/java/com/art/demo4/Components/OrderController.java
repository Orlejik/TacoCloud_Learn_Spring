package com.art.demo4.Components;

import com.art.demo4.Data.TacoOrder;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/current")
    public String orderForm(){
        log.info("orderForm was requested");
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors error, SessionStatus status){

        log.info("Order Submitted : "+order);

        if(error.hasErrors()){
            return "orderForm";
        }

        status.setComplete();

        return "redirect:/";
    }

}
