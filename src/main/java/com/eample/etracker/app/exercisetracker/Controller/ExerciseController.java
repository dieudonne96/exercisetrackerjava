package com.eample.etracker.app.exercisetracker.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eample.etracker.app.exercisetracker.Model.Exercise;
import com.eample.etracker.app.exercisetracker.Service.ExerciseService;

@RestController
@RequestMapping("/api/v1/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    // create an exercise
    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        return new ResponseEntity<>(exerciseService.createExercise(exercise), HttpStatus.CREATED);
    }

    // get all exercises
    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return new ResponseEntity<List<Exercise>>(exerciseService.allExercises(), HttpStatus.OK);
    }

    // get exercise by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Exercise>> getSingleExercise(@PathVariable Long id) {
        return new ResponseEntity<Optional<Exercise>>(exerciseService.singleExercise(id), HttpStatus.OK);
    }

    // update an exercise
    @PutMapping("/exercise/{id}")
    public ResponseEntity<Exercise> modifyExercise(@RequestBody Exercise exercise, @PathVariable("id") Long id) {
        Optional<Exercise> existingExercise = exerciseService.singleExercise(id);

        if (existingExercise.isPresent()) {
            Exercise updatedExercise = exerciseService.updateExercise(exercise, id);
            return ResponseEntity.ok(updatedExercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an exercise by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExerciseById(id);
        return ResponseEntity.noContent().build();
    }

    // delete all exercises
    // @DeleteMapping
    // public ResponseEntity<Void> deleteAllExercise() {
    // exerciseService.deleteAllExercise();
    // return ResponseEntity.noContent().build();
    // }
}
