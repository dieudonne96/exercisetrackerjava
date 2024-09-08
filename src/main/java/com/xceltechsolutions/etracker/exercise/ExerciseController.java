package com.xceltechsolutions.etracker.exercise;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//
@RestController
@RequestMapping("/api/v1/exercises")
public class ExerciseController {
    //
    private final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    // get all exercises
    @GetMapping("")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return new ResponseEntity<List<Exercise>>(exerciseRepository.findAll(), HttpStatus.OK);
    }

    // get exercise by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Exercise>> getSingleExercise(@PathVariable Integer id) {
        return new ResponseEntity<Optional<Exercise>>(exerciseRepository.findById(id), HttpStatus.OK);
    }

    // create an exercise
    @PostMapping
    public ResponseEntity<Void> createExercise(@Valid @RequestBody Exercise exercise) {
        exerciseRepository.createExercise(exercise);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // update an exercise
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/exercise/{id}")
    public ResponseEntity<Void> modifyExercise(@RequestBody Exercise exercise, @PathVariable("id") Integer id) {
        exerciseRepository.updateExercise(exercise, id);
        return ResponseEntity.noContent().build(); // 204 No Content for successful update
    }

    // delete an exercise by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Integer id) {
        exerciseRepository.deleteById(id);
    }

//     // delete all exercises
//     @ResponseStatus(HttpStatus.NO_CONTENT)
//     @DeleteMapping("/clearAll")
//     public void deleteAllExercise() {
//         exerciseService.deleteAllExercise();
//     }
}
