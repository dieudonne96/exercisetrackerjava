//package com.xceltechsolutions.etracker.Service;
//
//import com.xceltechsolutions.etracker.exercise.Exercise.ExerciseRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ExerciseService {
//
//    private final ExerciseRepository exerciseRepository;
//
//    public ExerciseService(ExerciseRepository exerciseRepository) {
//        this.exerciseRepository = exerciseRepository;
//    }
//
//    // CRUD Create, Read, Update, Delete
//
//    // CREATE
//    // create an exercise and insert into the database
////    public void createExercise(Exercise exercise) {
////        exerciseRepository.createExercise(exercise);
////    }
////
////    // READ ALL EXERCISES
////    // fetch all the exercises from the database
////    public List<Exercise> getAllExercises() {
////        return exerciseRepository.findAll();
////    }
////
////    // READ SINGLE EXERCISE
////    // fetch a single exercise from the database
////    // based on the exercise id received
////    public Optional<Exercise> getSingleExercise(Integer id) {
////        return exerciseRepository.findById(id);
////    }
////
////    // update an exercise
////    public void updateExercise(Exercise exercise, Integer id) {
////        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
////        if(optionalExercise.isPresent()) {
////            Exercise existingExercise = optionalExercise.get();
////            exerciseRepository.updateExercise(existingExercise, exercise);
////        } else {
////            throw new ResourceNotFoundException("Exercise not Found");
////        }
////    }
////
////    // delete an exercise
////    public void deleteExerciseById(Integer id) {
////        exerciseRepository.deleteById(id);
////
////    }
////
////    // delete all exercises
////     public void  deleteAllExercise() {
////         exerciseRepository.deleteAll();
////
////     }
//}
