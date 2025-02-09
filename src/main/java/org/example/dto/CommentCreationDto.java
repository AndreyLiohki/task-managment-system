package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentCreationDto {
    private String text;
    private LocalDateTime creationTime;
    private Long taskId;

}
