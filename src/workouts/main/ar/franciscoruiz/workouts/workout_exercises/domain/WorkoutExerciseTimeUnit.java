package ar.franciscoruiz.workouts.workout_exercises.domain;

public enum WorkoutExerciseTimeUnit {
    NONE("NONE"),
    SECONDS("SECONDS"),
    MINUTES("MINUTES"),
    HOURS("HOURS");

    private final String value;

    WorkoutExerciseTimeUnit(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
