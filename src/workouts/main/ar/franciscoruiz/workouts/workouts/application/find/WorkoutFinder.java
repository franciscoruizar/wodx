package ar.franciscoruiz.workouts.workouts.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.workouts.workouts.application.WorkoutResponse;
import ar.franciscoruiz.workouts.workouts.domain.Workout;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutNotExist;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutRepository;

@Service
public final class WorkoutFinder {
    private final WorkoutRepository repository;

    public WorkoutFinder(WorkoutRepository repository) {
        this.repository = repository;
    }

    public WorkoutResponse find(WorkoutId id) throws WorkoutNotExist {
        Workout workout = this.repository.search(id).orElseThrow(() -> new WorkoutNotExist(id));

        return new WorkoutResponse(
            workout.id().value(),
            workout.startDate(),
            workout.endDate(),
            workout.coachId().value()
        );
    }
}
