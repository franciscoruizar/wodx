package ar.franciscoruiz.apps.workouts.backend.controllers.step_exercises;

public final class WorkoutStepExerciseRequest {
    private String  id;
    private Integer series;
    private Integer value;
    private String  timeUnit;
    private String  stepId;
    private String  exerciseId;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer series() {
        return this.series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer value() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String timeUnit() {
        return this.timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String stepId() {
        return this.stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String exerciseId() {
        return this.exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }
}
