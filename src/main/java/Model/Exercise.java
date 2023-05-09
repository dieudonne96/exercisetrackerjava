package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    private ObjectId id;
    private String nameOfExercise;
    private String description;
    private String duration;
    private int numberOfSets;
    private int numberOfReps;
    private LocalDateTime timeCreated;
    private LocalDateTime timeUpdated;

}
