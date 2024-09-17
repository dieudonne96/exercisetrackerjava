package com.xceltechsolutions.etracker.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class ExerciseRepository {

    private static final Logger log = LoggerFactory.getLogger(ExerciseRepository.class);
    private final JdbcClient jdbcClient;

    public ExerciseRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Exercise> findAll() {
        return jdbcClient.sql("SELECT * FROM exercise")
                .query(Exercise.class)
                .list();
    }

    // READ SINGLE
    public Optional<Exercise> findById(Integer id) {
        return jdbcClient.sql("SELECT id, nameOfExercise, description, duration, numberOfSets, numberOfReps, timeCreated, timeUpdated FROM exercise WHERE id = :id")
                .param("id", id)
                .query(Exercise.class)
                .optional();
    }

    // CREATE
    public void createExercise(Exercise exercise) {
        var newExercise = jdbcClient
                .sql("INSERT INTO exercise(id, nameOfExercise, description, duration, numberOfSets, numberOfReps, timeCreated, timeUpdated) VALUES(?,?,?,?,?,?,?,?)")
                .params(List.of(exercise.id(), exercise.nameOfExercise(), exercise.description(), exercise.duration(), exercise.numberOfSets(), exercise.numberOfReps(), exercise.timeCreated(), exercise.timeUpdated()))
                .update();

        Assert.state(newExercise == 1, "Failed to create exercise " + exercise.nameOfExercise());
    }

    // UPDATE EXERCISE
    public void updateExercise(Exercise exercise, Integer id) {
        var updated = jdbcClient.sql("UPDATE exercise SET nameOfExercise = ?, description =?, duration=?, numberOfSets=?, numberOfReps=?, timeCreated=?, timeUpdated=? WHERE id =?")
                .params(List.of(exercise.nameOfExercise(), exercise.description(), exercise.duration(), exercise.numberOfSets(), exercise.numberOfReps(), exercise.timeCreated(), exercise.timeUpdated(), id))
                .update();

        Assert.state(updated == 1, "Failed to update exercise " + exercise.nameOfExercise());
    }

    // DELETE SINGLE EXERCISE
    public void deleteById(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM exercise WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete exercise " + id);
    }

    //    // DELETE ALL EXERCISES
    //    public void deleteAll() {
    //        exercises.clear();
    //    }

    public int count() {
        return jdbcClient.sql("SELECT COUNT(*) FROM exercise")
                .query()
                .listOfRows()
                .size();
    }

    public void saveAll(List<Exercise> exercises) {
        exercises.stream().forEach(this::createExercise);
    }

}