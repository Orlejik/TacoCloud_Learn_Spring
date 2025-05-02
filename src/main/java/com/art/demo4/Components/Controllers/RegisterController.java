package com.art.demo4.Components.Controllers;


import com.art.demo4.Data.RegistrationForm;
import com.art.demo4.Repositories.TestRepos.RoleRepository;
import com.art.demo4.Repositories.TestRepos.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final RoleRepository roleRepo;

    public RegisterController(UserRepository userRepo, PasswordEncoder passwordEncoder, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
    }

    @GetMapping
    public String registerForm(Model model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }
    @PostMapping
    public String pregistrationProcess(@Valid RegistrationForm form, BindingResult bindingResult, Model model){
        userRepo.save(form.toUser(passwordEncoder, roleRepo));
        return "redirect:/login";
    }
}
