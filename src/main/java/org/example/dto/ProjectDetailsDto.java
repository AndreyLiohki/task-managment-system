package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProjectDetailsDto {

    private Long projectId;
    private String name;
    private String description;
    private LocalDateTime starterDate;
    private CreatorInfoDto creator;
    private List<UserPublicDto> participants;
    private List<TaskSummaryDto> projectTasks;
}
