package com.art.demo4.Components.Controllers;


import com.art.demo4.Data.RegistrationForm;
import com.art.demo4.Repositories.TestRepos.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }
    @PostMapping
    public String pregistrationProcess(@Valid RegistrationForm form, BindingResult bindingResult, Model model){
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}