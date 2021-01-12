package ar.franciscoruiz.workouts.workouts.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.workouts.workouts.domain.Workout;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutRepository;

import java.time.LocalDateTime;

@Service
public final class WorkoutCreator {
    private final WorkoutRepository repository;

    public WorkoutCreator(WorkoutRepository repository) {
        this.repository = repository;
    }

    public void create(WorkoutId id, LocalDateTime startDate, LocalDateTime endDate, UserId coachId) {
        Workout workout = new Workout(id, startDate, endDate, coachId);

        this.repository.save(workout);
    }
}
