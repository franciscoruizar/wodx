package ar.franciscoruiz.apps.workouts.backend.controllers.steps;

public final class StepRequest {
    private String id;
    private String description;
    private String stepTypeId;
    private String workoutId;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String description() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String stepTypeId() {
        return this.stepTypeId;
    }

    public void setStepTypeId(String stepTypeId) {
        this.stepTypeId = stepTypeId;
    }

    public String workoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }
}
