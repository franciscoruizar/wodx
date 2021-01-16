package ar.franciscoruiz.workouts.step_types.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateStepTypeCommand implements Command {
    private final String id;
    private final String description;

    public CreateStepTypeCommand(String id, String description) {
        this.id          = id;
        this.description = description;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }
}
