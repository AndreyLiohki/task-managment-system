package org.example.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserHomePageDto {

    private Long userId;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String username;
    private String email;
    private List<JoinedProjectSummaryDto> joinedProjects;
    private List<CreatedProjectSummaryDto> createdProjects;

}
