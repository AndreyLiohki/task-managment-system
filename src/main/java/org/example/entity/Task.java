package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.utils.LocalDateTimeConverter;
import org.example.utils.Status;
import org.example.utils.TaskPriority;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_title")
    private String title;

    @Column(name = "task_description")
    private String description;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "task_priority")
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column(name = "task_creationDate")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime creationTime;

    @ManyToMany
    @JoinTable(name = "user_task",
                joinColumns = @JoinColumn(name = "task_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<AppUser> participants;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;


}
