package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserEditionDto {

    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String username;
    private String emaill;

}
