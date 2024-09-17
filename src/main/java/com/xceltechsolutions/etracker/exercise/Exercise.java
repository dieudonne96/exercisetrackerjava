package com.xceltechsolutions.etracker.exercise;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record Exercise(
        @Id
        Integer id,
        @NotEmpty
        String nameOfExercise,
        String description,
        @NotEmpty
        String duration,
        @PositiveOrZero
        Integer numberOfSets,
        @PositiveOrZero
        Integer numberOfReps,
        LocalDateTime timeCreated,
        LocalDateTime timeUpdated
) {
}