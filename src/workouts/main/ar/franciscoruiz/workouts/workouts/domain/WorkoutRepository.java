package ar.franciscoruiz.workouts.workouts.domain;

import java.util.Optional;

public interface WorkoutRepository {
    void save(Workout workout);

    Optional<Workout> search(WorkoutId id);
}
