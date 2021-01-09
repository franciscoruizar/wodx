package ar.franciscoruiz.workouts.workout_exercises.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface WorkoutExerciseRepository {
    void save(WorkoutExercise workoutExercise);

    Optional<WorkoutExercise> search(WorkoutExerciseId id);

    List<WorkoutExercise> matching(Criteria criteria);
}

