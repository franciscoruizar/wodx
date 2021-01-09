package ar.franciscoruiz.workouts.exercises.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository {
    void save(Exercise exercise);

    Optional<Exercise> search(ExerciseId id);

    List<Exercise> matching(Criteria criteria);
}

