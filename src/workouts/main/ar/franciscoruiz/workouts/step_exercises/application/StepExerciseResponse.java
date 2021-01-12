package ar.franciscoruiz.workouts.step_exercises.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;

public final class StepExerciseResponse implements Response {
    private final String           id;
    private final Integer          series;
    private final Integer          value;
    private final String           timeUnit;
    private final String           stepId;
    private final ExerciseResponse exercise;

    public StepExerciseResponse(String id, Integer series, Integer value, String timeUnit, String stepId, ExerciseResponse exercise) {
        this.id       = id;
        this.series   = series;
        this.value    = value;
        this.timeUnit = timeUnit;
        this.stepId   = stepId;
        this.exercise = exercise;
    }

    public String id() {
        return this.id;
    }

    public Integer series() {
        return this.series;
    }

    public Integer value() {
        return this.value;
    }

    public String timeUnit() {
        return this.timeUnit;
    }

    public String stepId() {
        return this.stepId;
    }

    public ExerciseResponse exercise() {
        return this.exercise;
    }
}
