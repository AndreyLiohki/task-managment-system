package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRegistrationDto {

    private String firstname;
    private String lastname;
    private String username;
    private LocalDate birthday;
    private String password;
    private String email;

}
