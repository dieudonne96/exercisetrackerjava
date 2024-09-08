CREATE TABLE IF NOT EXISTS Exercise (
    id INT PRIMARY KEY,        -- Corresponds to Long id with @GeneratedValue
    nameOfExercise VARCHAR(255) NOT NULL,        -- Corresponds to String nameOfExercise
    description TEXT,                            -- Corresponds to String description (can hold longer text)
    duration VARCHAR(50),                        -- Corresponds to String duration (assuming it's a time format like '30 minutes')
    numberOfSets INT NOT NULL,                   -- Corresponds to int numberOfSets
    numberOfReps INT NOT NULL,                   -- Corresponds to int numberOfReps
    timeCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Corresponds to LocalDateTime timeCreated
    timeUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Corresponds to LocalDateTime timeUpdated
);
