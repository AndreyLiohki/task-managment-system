package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatedProjectSummaryDto {

    private Long projectId;
    private String name;
    private LocalDateTime starterDate;

}
