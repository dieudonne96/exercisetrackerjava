package com.xceltechsolutions.etracker;

import com.xceltechsolutions.etracker.exercise.Exercise;
import com.xceltechsolutions.etracker.exercise.ExerciseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ETApplication {

    private static final Logger log = LoggerFactory.getLogger(ETApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ETApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(ExerciseRepository exerciseRepository) {
//        return args -> {
//            Exercise exercise = new Exercise(
//                    1,                     // id
//                    "Sit Ups",             // nameOfExercise
//                    "Push-up exercise",     // description
//                    "30 minutes",           // duration
//                    3,                      // numberOfSets
//                    10,                     // numberOfReps
//                    LocalDateTime.now().minusDays(3),    // timeCreated
//                    LocalDateTime.now()     // timeUpdated
//            );
//            exerciseRepository.createExercise(exercise);
//            //log.info("Exercise: " + exercise);
//        };
//    }

}
