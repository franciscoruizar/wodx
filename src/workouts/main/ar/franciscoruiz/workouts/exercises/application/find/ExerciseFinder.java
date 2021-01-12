package ar.franciscoruiz.workouts.exercises.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseNotExist;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseRepository;

@Service
public final class ExerciseFinder {
    private final ExerciseRepository repository;

    public ExerciseFinder(ExerciseRepository repository) {
        this.repository = repository;
    }

    public ExerciseResponse find(ExerciseId id) throws ExerciseNotExist {
        return repository.search(id)
                         .map(ExerciseResponse::fromAggregate)
                         .orElseThrow(() -> new ExerciseNotExist(id));
    }
}
