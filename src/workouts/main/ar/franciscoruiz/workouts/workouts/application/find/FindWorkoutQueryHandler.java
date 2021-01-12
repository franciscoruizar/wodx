package ar.franciscoruiz.workouts.workouts.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.workouts.workouts.application.WorkoutResponse;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutNotExist;

@Service
public final class FindWorkoutQueryHandler implements QueryHandler<FindWorkoutQuery, WorkoutResponse> {
    private final WorkoutFinder finder;

    public FindWorkoutQueryHandler(WorkoutFinder finder) {
        this.finder = finder;
    }

    @Override
    public WorkoutResponse handle(FindWorkoutQuery query) throws WorkoutNotExist {
        return finder.find(new WorkoutId(query.id()));
    }
}
