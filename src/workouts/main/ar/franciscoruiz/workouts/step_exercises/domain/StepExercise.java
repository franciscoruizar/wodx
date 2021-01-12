package ar.franciscoruiz.workouts.step_exercises.domain;

import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.steps.domain.StepId;

import java.util.Objects;

public final class StepExercise {
    private final StepExerciseId       id;
    private final StepExerciseSeries   series;
    private final StepExerciseValue    value;
    private final StepExerciseTimeUnit timeUnit;
    private final StepId               stepId;
    private final ExerciseId           exerciseId;

    public StepExercise(
        StepExerciseId id,
        StepExerciseSeries series,
        StepExerciseValue value,
        StepExerciseTimeUnit timeUnit,
        StepId stepId,
        ExerciseId exerciseId
    ) {
        this.id         = id;
        this.series     = series;
        this.value      = value;
        this.timeUnit   = timeUnit;
        this.stepId     = stepId;
        this.exerciseId = exerciseId;
    }

    public StepExercise() {
        this.id         = null;
        this.series     = null;
        this.value      = null;
        this.timeUnit   = null;
        this.stepId     = null;
        this.exerciseId = null;
    }

    public StepExerciseId id() {
        return this.id;
    }

    public StepExerciseSeries series() {
        return this.series;
    }

    public StepExerciseValue value() {
        return this.value;
    }

    public StepExerciseTimeUnit timeUnit() {
        return this.timeUnit;
    }

    public StepId stepId() {
        return this.stepId;
    }

    public ExerciseId exerciseId() {
        return this.exerciseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepExercise that = (StepExercise) o;
        return Objects.equals(id, that.id) && Objects.equals(series, that.series) && Objects.equals(value, that.value) && timeUnit == that.timeUnit && Objects.equals(stepId, that.stepId) && Objects.equals(exerciseId, that.exerciseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, value, timeUnit, stepId, exerciseId);
    }
}
