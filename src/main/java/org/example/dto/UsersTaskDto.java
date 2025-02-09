package org.example.dto;

import lombok.Data;
import org.example.utils.Status;
import org.example.utils.TaskPriority;

import java.util.List;

@Data
public class UsersTaskDto {

    private Long taskId;
    private String title;
    private String description;
    private Status status;
    private TaskPriority priority;
    private List<CommentDto> taskComments;
    private List<UserPublicDto> taskParticipants;

}
