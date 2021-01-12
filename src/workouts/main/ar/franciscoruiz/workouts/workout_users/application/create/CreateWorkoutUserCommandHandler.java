package ar.franciscoruiz.workouts.workout_users.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

@Service
public final class CreateWorkoutUserCommandHandler implements CommandHandler<CreateWorkoutUserCommand> {
    private final WorkoutUserCreator creator;

    public CreateWorkoutUserCommandHandler(WorkoutUserCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateWorkoutUserCommand command) {
        WorkoutUserId id        = new WorkoutUserId(command.id());
        WorkoutId     workoutId = new WorkoutId(command.workoutId());
        UserId        athleteId = new UserId(command.athleteId());

        this.creator.create(id, workoutId, athleteId);
    }
}
