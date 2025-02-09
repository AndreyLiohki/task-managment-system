package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectCreationDto {

    private String name;
    private String description;
    private LocalDateTime creationTime;
    private CreatorInfoDto createdBy;

}
