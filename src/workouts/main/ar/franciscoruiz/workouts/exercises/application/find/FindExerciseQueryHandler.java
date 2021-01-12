package ar.franciscoruiz.workouts.exercises.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseNotExist;

@Service
public final class FindExerciseQueryHandler implements QueryHandler<FindExerciseQuery, ExerciseResponse> {
    private final ExerciseFinder finder;

    public FindExerciseQueryHandler(ExerciseFinder finder) {
        this.finder = finder;
    }

    @Override
    public ExerciseResponse handle(FindExerciseQuery query) throws ExerciseNotExist {
        return finder.find(new ExerciseId(query.id()));
    }
}
