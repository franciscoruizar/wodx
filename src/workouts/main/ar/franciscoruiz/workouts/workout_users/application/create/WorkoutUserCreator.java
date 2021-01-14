package ar.franciscoruiz.workouts.workout_users.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUser;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserId;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserRepository;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

@Service
public final class WorkoutUserCreator {
    private final WorkoutUserRepository repository;

    public WorkoutUserCreator(WorkoutUserRepository repository) {
        this.repository = repository;
    }

    public void create(WorkoutUserId id, WorkoutId workoutId, UserId athleteId) {
        WorkoutUser workoutUser = new WorkoutUser(id.value(), workoutId.value(), athleteId.value());

        this.repository.save(workoutUser);
    }
}
