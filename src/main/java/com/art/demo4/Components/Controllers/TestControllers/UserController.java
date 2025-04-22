package com.art.demo4.Components.Controllers.TestControllers;

import com.art.demo4.Data.User;
import com.art.demo4.Repositories.TestRepos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;

    @GetMapping("/users/all")
    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }
}
