package ar.franciscoruiz.workouts.step_types.domain;

public final class StepType {
    private final String id;
    private final String description;

    public StepType(String id, String description) {
        this.id          = id;
        this.description = description;
    }

    public StepType() {
        this.id          = null;
        this.description = null;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }
}
