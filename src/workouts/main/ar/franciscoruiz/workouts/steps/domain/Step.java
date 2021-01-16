package ar.franciscoruiz.workouts.steps.domain;

public final class Step {
    private final String id;
    private final String description;
    private final String stepTypeId;
    private final String workoutId;

    public Step(String id, String description, String stepTypeId, String workoutId) {
        this.id          = id;
        this.description = description;
        this.stepTypeId  = stepTypeId;
        this.workoutId   = workoutId;
    }

    public Step() {
        this.id          = null;
        this.description = null;
        this.stepTypeId  = null;
        this.workoutId   = null;
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
