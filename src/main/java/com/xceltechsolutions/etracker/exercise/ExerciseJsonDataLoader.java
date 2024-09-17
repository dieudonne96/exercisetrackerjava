package com.xceltechsolutions.etracker.exercise;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ExerciseJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ExerciseJsonDataLoader.class);
    private final ExerciseRepository exerciseRepository;
    private final ObjectMapper objectMapper;

    public ExerciseJsonDataLoader(ExerciseRepository exerciseRepository, ObjectMapper objectMapper) {
        this.exerciseRepository = exerciseRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (exerciseRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/exercises.json")) {
                Exercises allExercises = objectMapper.readValue(inputStream, Exercises.class);
                log.info("Reading {} exercises from JSON data and saving to a database.", allExercises.exercises().size());
                exerciseRepository.saveAll(allExercises.exercises());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Exercises from JSON data because the collection contains data.");
        }
    }
}
