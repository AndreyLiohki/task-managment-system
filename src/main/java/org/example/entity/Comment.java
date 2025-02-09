package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.utils.LocalDateTimeConverter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_text")
    private String text;

    @Column(name = "comment_creationDate")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
}
