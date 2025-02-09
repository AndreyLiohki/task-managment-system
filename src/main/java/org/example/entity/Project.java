package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.utils.LocalDateTimeConverter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String name;

    @Column(name = "project_description")
    private String description;

    @Column(name = "project_starterDate")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime starterDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser creator;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> projectTasks;

    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<AppUser> projectParticipants;
}
