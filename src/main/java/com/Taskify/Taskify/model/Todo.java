package com.Taskify.Taskify.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todos")
@Data
public class Todo {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @Column(name = "completed", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean completed = true;

    @Column(name = "reminder_time")
    private LocalTime reminderTime;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

}
