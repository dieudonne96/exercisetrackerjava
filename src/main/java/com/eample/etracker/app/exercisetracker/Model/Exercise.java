package com.eample.etracker.app.exercisetracker.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;
    private String nameOfExercise;
    private String description;
    private String duration;
    private int numberOfSets;
    private int numberOfReps;
    private LocalDateTime timeCreated;
    private LocalDateTime timeUpdated;

}
