package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.utils.LocalDateConverter;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "user_firstname")
    private String firstname;

    @Column(name = "user_lastname")
    private String lastname;

    @Column(name = "user_birthdate")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate birthdate;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Project> createdProjects;

    @ManyToMany(mappedBy = "projectParticipants")
    private List<Project> joinedProjects;

    @ManyToMany(mappedBy = "participants")
    List<Task> usersTasks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> usersNotifications;
}
