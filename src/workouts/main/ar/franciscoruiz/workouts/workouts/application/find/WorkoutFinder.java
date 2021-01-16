package ar.franciscoruiz.workouts.workouts.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.workouts.steps.application.StepsResponse;
import ar.franciscoruiz.workouts.steps.application.search_by_criteria.SearchStepsByCriteriaQuery;
import ar.franciscoruiz.workouts.workout_users.application.WorkoutUserResponse;
import ar.franciscoruiz.workouts.workout_users.application.WorkoutUsersResponse;
import ar.franciscoruiz.workouts.workout_users.application.search_by_criteria.SearchWorkoutUsersByCriteriaQuery;
import ar.franciscoruiz.workouts.workouts.application.WorkoutResponse;
import ar.franciscoruiz.workouts.workouts.domain.Workout;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutNotExist;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class WorkoutFinder {
    private final WorkoutRepository repository;

    public WorkoutFinder(WorkoutRepository repository) {
        this.repository = repository;
    }

    public WorkoutResponse find(WorkoutId id) throws WorkoutNotExist {
        Workout       workout       = this.repository.search(id).orElseThrow(() -> new WorkoutNotExist(id));

        return new WorkoutResponse(
            workout.id().value(),
            workout.startDate(),
            workout.endDate(),
            workout.coachId().value()
        );
    }
}
