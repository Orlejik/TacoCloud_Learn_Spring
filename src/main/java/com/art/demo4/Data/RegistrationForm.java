package com.art.demo4.Data;

import com.art.demo4.Repositories.TestRepos.RoleRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Data
public class RegistrationForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String fullName;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zip;

    public User toUser(PasswordEncoder passwordEncoder, RoleRepository roleRepo){
        Role role = roleRepo.findByRoleName("ROLE_USER");
        if(role == null){
            role = new Role("ROLE_USER");
            roleRepo.save(role);
        }
        User newUser =  new User(
                username,
                passwordEncoder.encode(password),
                fullName,
                email,
                phone,
                street,
                city,
                state,
                zip
        );
        newUser.setRoles(List.of(role));
        return newUser;
    }
}
