package org.example.controller;

import org.example.dto.CreatedProjectSummaryDto;
import org.example.dto.UserEditionDto;
import org.example.entity.AppUser;
import org.example.service.UserService;
import org.springframework.security.core.Authentication;
import org.example.dto.UserHomePageDto;
import org.example.service.CommentService;
import org.example.service.ProjectService;
import org.example.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final CommentService commentService;
    private final UserService userService;

    public UserController(TaskService taskService, ProjectService projectService, CommentService commentService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/user/homepage")
    public ResponseEntity<UserHomePageDto> loadHomePage(Authentication authentication){
        final String username = authentication.getName();
        return ResponseEntity.ok(userService.loadHomePage(username));
    }

    @PutMapping("/user/edit")
    public ResponseEntity<String> editProfile(@RequestBody UserEditionDto userEditionDto, Authentication authentication){
        final String username = authentication.getName();
    }
}
