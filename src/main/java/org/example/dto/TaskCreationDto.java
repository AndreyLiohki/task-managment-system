package org.example.dto;

import lombok.Data;
import org.example.utils.Status;
import org.example.utils.TaskPriority;

import java.time.LocalDateTime;

@Data
public class TaskCreationDto {

    private String title;
    private String description;
    private Status status;
    private TaskPriority priority;
    private LocalDateTime creationTime;

}
