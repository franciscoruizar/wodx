package ar.franciscoruiz.workouts.step_exercises.domain;

public enum StepExerciseTimeUnit {
    NONE("NONE"),
    SECONDS("SECONDS"),
    MINUTES("MINUTES"),
    HOURS("HOURS");

    private final String value;

    StepExerciseTimeUnit(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
