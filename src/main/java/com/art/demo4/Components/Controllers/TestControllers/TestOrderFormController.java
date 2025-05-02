package com.art.demo4.Components.Controllers.TestControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestOrderFormController {

    @GetMapping("/order-form")
    public String orderForm() {
        return "orderForm";
    }
}
