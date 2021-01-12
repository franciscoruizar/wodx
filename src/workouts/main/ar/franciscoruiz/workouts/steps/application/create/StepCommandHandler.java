package ar.franciscoruiz.workouts.steps.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.steps.domain.StepDescription;
import ar.franciscoruiz.workouts.steps.domain.StepId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

@Service
public final class StepCommandHandler implements CommandHandler<StepCommand> {
    private final StepCreator creator;

    public StepCommandHandler(StepCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(StepCommand command) {
        StepId          id          = new StepId(command.id());
        StepDescription description = new StepDescription(command.description());
        StepTypeId      stepTypeId  = new StepTypeId(command.stepTypeId());
        WorkoutId       workoutId   = new WorkoutId(command.workoutId());

        this.creator.create(id, description, stepTypeId, workoutId);
    }
}
