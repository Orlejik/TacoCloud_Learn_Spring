package com.art.demo4.Components.Controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tacos", produces = {"application/json", "text/xml"})
@CrossOrigin(origins = {"https://tacocloud:8081", "http://localhost:8081"})
public class TacoController {
//    private final TacoRepository tacoRepo;
//
//    public TacoController(TacoRepository tacoRepo){
//        this.tacoRepo = tacoRepo;
//    }
//
//    @GetMapping(params = "recent")
//    public List<Taco> recentTacos(){
//        PageRequest page = PageRequest.of(0,12, Sort.by("createdAt").descending());
//        return tacoRepo.findAll(page).getContent();
//    }
}
