package com.eample.etracker.app.exercisetracker.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eample.etracker.app.exercisetracker.Model.Exercise;
import com.eample.etracker.app.exercisetracker.Repositories.ExerciseRepository;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    // CRUD Create, Read, Update, Delete

    // create an exercise and insert into the database
    public Exercise createExercise(Exercise exercise) {
        exercise.setTimeCreated(LocalDateTime.now());
        return exerciseRepository.save(exercise);
    }

    // fetch all the exercises from the database
    public List<Exercise> allExercises() {
        return exerciseRepository.findAll();
    }

    // fetch a single exercise from the database
    // based on the exercise id received
    public Optional<Exercise> singleExercise(Long id) {
        return exerciseRepository.findById(id);
    }

    // update an exercise
    public Exercise updateExercise(Exercise exercise, Long id) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
        if(optionalExercise.isPresent()) {
            Exercise existingExercise = optionalExercise.get();
            existingExercise.setNameOfExercise(exercise.getNameOfExercise());
            existingExercise.setDescription(exercise.getDescription());
            existingExercise.setDuration(exercise.getDuration());
            existingExercise.setNumberOfSets(exercise.getNumberOfSets());
            existingExercise.setNumberOfReps(exercise.getNumberOfReps());
            existingExercise.setTimeUpdated(LocalDateTime.now());
            return exerciseRepository.save(existingExercise);
        } else {
            throw new ResourceNotFoundException("Exercise not Found");
        }
    }

    // delete an exercise
    public void  deleteExerciseById(Long id) {
        exerciseRepository.deleteById(id);
    }

    // delete all exercises
    // public void  deleteAllExercise() {
    //     exerciseRepository.deleteAll();
    // }
}
