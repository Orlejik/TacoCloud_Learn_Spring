package com.art.demo4.Data;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(
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
    }
}
