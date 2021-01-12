package ar.franciscoruiz.workouts.step_exercises.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface StepExerciseRepository {
    void save(StepExercise stepExercise);

    Optional<StepExercise> search(StepExerciseId id);

    List<StepExercise> matching(Criteria criteria);
}

