package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JoinedProjectSummaryDto {

    private Long projectId;
    private String name;
    private LocalDateTime creationDate;
    private CreatorInfoDto creator;
}
