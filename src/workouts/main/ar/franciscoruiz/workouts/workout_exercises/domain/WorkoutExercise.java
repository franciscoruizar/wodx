package ar.franciscoruiz.workouts.workout_exercises.domain;

import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

import java.util.Objects;

public final class WorkoutExercise {
    private final WorkoutExerciseId       id;
    private final WorkoutExerciseSeries   series;
    private final WorkoutExerciseValue    value;
    private final WorkoutExerciseTimeUnit timeUnit;
    private final WorkoutId               workoutId;
    private final ExerciseId              exerciseId;

    public WorkoutExercise(WorkoutExerciseId id, WorkoutExerciseSeries series, WorkoutExerciseValue value, WorkoutExerciseTimeUnit timeUnit, WorkoutId workoutId, ExerciseId exerciseId) {
        this.id         = id;
        this.series     = series;
        this.value      = value;
        this.timeUnit   = timeUnit;
        this.workoutId  = workoutId;
        this.exerciseId = exerciseId;
    }

    public WorkoutExercise() {
        this.id         = null;
        this.series     = null;
        this.value      = null;
        this.timeUnit   = null;
        this.workoutId  = null;
        this.exerciseId = null;
    }

    public WorkoutExerciseId id() {
        return this.id;
    }

    public WorkoutExerciseSeries series() {
        return this.series;
    }

    public WorkoutExerciseValue value() {
        return this.value;
    }

    public WorkoutExerciseTimeUnit timeUnit() {
        return this.timeUnit;
    }

    public WorkoutId workoutId() {
        return this.workoutId;
    }

    public ExerciseId exerciseId() {
        return this.exerciseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutExercise that = (WorkoutExercise) o;
        return Objects.equals(id, that.id) && Objects.equals(series, that.series) && Objects.equals(value, that.value) && timeUnit == that.timeUnit && Objects.equals(workoutId, that.workoutId) && Objects.equals(exerciseId, that.exerciseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, value, timeUnit, workoutId, exerciseId);
    }
}
