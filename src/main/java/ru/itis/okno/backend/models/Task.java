package ru.itis.okno.backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private Boolean isCompleted;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    public String description;
    private LocalDateTime creationDate;
    private LocalDateTime deadlineDate;
    private LocalDateTime accomplishmentDate;
}
