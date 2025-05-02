package com.art.demo4.Components.Controllers.TestControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/expired")
public class ExpiredController {

    @GetMapping
    public String expired() {
        return "expired";
    }

}
