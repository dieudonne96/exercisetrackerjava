package com.eample.etracker.app.exercisetracker.Controller;

import com.eample.etracker.app.exercisetracker.Model.Exercise;
import com.eample.etracker.app.exercisetracker.Service.ExerciseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Exercise>> getSingleExercise(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Exercise>>(exerciseService.singleExercise(id), HttpStatus.OK);
    }

    // update an exercise
    @PutMapping("/exercise/{id}")
    public ResponseEntity<Exercise> modifyExercise(@RequestBody Exercise exercise, @PathVariable("id") ObjectId id) {
        Optional<Exercise> existingExercise = exerciseService.singleExercise(id);

        if(existingExercise.isPresent()) {
            Exercise updatedExercise = exerciseService.updateExercise(exercise, id);
            return ResponseEntity.ok(updatedExercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete an exercise by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable ObjectId id) {
        exerciseService.deleteExerciseById(id);
        return ResponseEntity.noContent().build();
    }

    // delete all exercises
    @DeleteMapping
    public ResponseEntity<Void> deleteAllExercise() {
        exerciseService.deleteAllExercise();
        return ResponseEntity.noContent().build();
    }
}
