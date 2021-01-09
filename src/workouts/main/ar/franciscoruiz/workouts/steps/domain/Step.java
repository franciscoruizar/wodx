package ar.franciscoruiz.workouts.steps.domain;

import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

import java.util.Objects;

public final class Step {
    private final StepId          id;
    private final StepDescription description;
    private final StepTypeId      stepTypeId;
    private final WorkoutId       workoutId;

    public Step(StepId id, StepDescription description, StepTypeId stepTypeId, WorkoutId workoutId) {
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

    public StepId id() {
        return this.id;
    }

    public StepDescription description() {
        return this.description;
    }

    public StepTypeId stepTypeId() {
        return this.stepTypeId;
    }

    public WorkoutId workoutId() {
        return this.workoutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return Objects.equals(id, step.id) && Objects.equals(description, step.description) && Objects.equals(stepTypeId, step.stepTypeId) && Objects.equals(workoutId, step.workoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, stepTypeId, workoutId);
    }
}
