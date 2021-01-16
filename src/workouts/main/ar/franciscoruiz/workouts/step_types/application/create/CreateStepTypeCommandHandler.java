package ar.franciscoruiz.workouts.step_types.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeDescription;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;

@Service
public final class CreateStepTypeCommandHandler implements CommandHandler<CreateStepTypeCommand> {
    private final StepTypeCreator creator;

    public CreateStepTypeCommandHandler(StepTypeCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateStepTypeCommand command) {
        StepTypeId          id          = new StepTypeId(command.id());
        StepTypeDescription description = new StepTypeDescription(command.description());

        this.creator.create(id, description);
    }
}
