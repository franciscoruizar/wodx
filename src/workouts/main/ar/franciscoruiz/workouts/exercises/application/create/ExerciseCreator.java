package ar.franciscoruiz.workouts.exercises.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.workouts.exercises.domain.*;

@Service
public final class ExerciseCreator {
    private final ExerciseRepository repository;

    public ExerciseCreator(ExerciseRepository repository) {
        this.repository = repository;
    }

    public void create(ExerciseId id, ExerciseDescription description, ExerciseMediaUrl mediaUrl) {
        Exercise exercise = new Exercise(id.value(), description.value(), mediaUrl.value());

        this.repository.save(exercise);
    }
}
