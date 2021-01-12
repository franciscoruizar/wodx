package ar.franciscoruiz.workouts.workouts.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

import java.time.LocalDateTime;

@Service
public final class CreateWorkoutCommandHandler implements CommandHandler<CreateWorkoutCommand> {
    private final WorkoutCreator creator;

    public CreateWorkoutCommandHandler(WorkoutCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateWorkoutCommand command) {
        WorkoutId     id        = new WorkoutId(command.id());
        LocalDateTime startDate = command.startDate();
        LocalDateTime endDate   = command.endDate();
        UserId        coachId   = new UserId(command.coachId());

        this.creator.create(id, startDate, endDate, coachId);
    }
}
