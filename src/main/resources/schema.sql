CREATE TABLE IF NOT EXISTS exercise (
    id SERIAL PRIMARY KEY,                             -- Auto-incrementing id
    nameOfExercise VARCHAR(255) NOT NULL,              -- Corresponds to String nameOfExercise
    description TEXT,                                  -- Corresponds to String description
    duration VARCHAR(50),                              -- Corresponds to String duration
    numberOfSets INT NOT NULL,                         -- Corresponds to int numberOfSets
    numberOfReps INT NOT NULL,                         -- Corresponds to int numberOfReps
    timeCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- Corresponds to LocalDateTime timeCreated
    timeUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP    -- Corresponds to LocalDateTime timeUpdated
);
--
---- Trigger function to auto-update the timeUpdated field
--CREATE OR REPLACE FUNCTION update_time_updated_column()
--RETURNS TRIGGER AS $$
--BEGIN
--   NEW.timeUpdated = NOW();
--   RETURN NEW;
--END;
--$$ LANGUAGE plpgsql;
--
---- Trigger to call the function before update on the exercise table
--CREATE TRIGGER update_time_updated_trigger
--BEFORE UPDATE ON exercise
--FOR EACH ROW
--EXECUTE FUNCTION update_time_updated_column();
