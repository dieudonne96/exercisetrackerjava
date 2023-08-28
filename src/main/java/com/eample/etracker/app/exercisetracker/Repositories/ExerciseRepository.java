package com.eample.etracker.app.exercisetracker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eample.etracker.app.exercisetracker.Model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
