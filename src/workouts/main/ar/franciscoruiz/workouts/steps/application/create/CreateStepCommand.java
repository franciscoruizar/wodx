package ar.franciscoruiz.workouts.steps.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateStepCommand implements Command {
    private final String id;
    private final String description;
    private final String stepTypeId;
    private final String workoutId;

    public CreateStepCommand(String id, String description, String stepTypeId, String workoutId) {
        this.id          = id;
        this.description = description;
        this.stepTypeId  = stepTypeId;
        this.workoutId   = workoutId;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public String stepTypeId() {
        return this.stepTypeId;
    }

    public String workoutId() {
        return this.workoutId;
    }
}
