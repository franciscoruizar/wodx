package ar.franciscoruiz.workouts.step_types.domain;

public final class StepType {
    private final StepTypeId          id;
    private final StepTypeDescription description;

    public StepType(StepTypeId id, StepTypeDescription description) {
        this.id          = id;
        this.description = description;
    }

    public StepType() {
        this.id          = null;
        this.description = null;
    }

    public StepTypeId id() {
        return this.id;
    }

    public StepTypeDescription description() {
        return this.description;
    }
}
