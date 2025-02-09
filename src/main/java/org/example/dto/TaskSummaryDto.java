package org.example.dto;

import lombok.Data;

@Data
public class TaskSummaryDto {
    private Long taskId;
    private String title;
    private String description;
}
