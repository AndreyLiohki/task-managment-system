package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.utils.LocalDateTimeConverter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    @Column(name = "notification_message")
    private String message;

    @Column(name = "notification_creationDate")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
}
