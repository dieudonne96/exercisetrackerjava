package com.eample.etracker.app.exercisetracker.Repositories;

import com.eample.etracker.app.exercisetracker.Model.Exercise;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, ObjectId> {
}
