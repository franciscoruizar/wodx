package ar.franciscoruiz.workouts.steps.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;
import ar.franciscoruiz.workouts.step_exercises.StepExercisesResponse;
import ar.franciscoruiz.workouts.steps.domain.Step;

import java.util.Collections;

public final class StepResponse implements Response {
    private final String                id;
    private final String                description;
    private final String                stepTypeId;
    private final String                workoutId;
    private final StepExercisesResponse stepExercises;

    public StepResponse(String id, String description, String stepTypeId, String workoutId) {
        this.id          = id;
        this.description = description;
        this.stepTypeId  = stepTypeId;
        this.workoutId   = workoutId;
        this.stepExercises = new StepExercisesResponse(Collections.emptyList());
    }

    public StepResponse(String id, String description, String stepTypeId, String workoutId, StepExercisesResponse stepExercises) {
        this.id            = id;
        this.description   = description;
        this.stepTypeId    = stepTypeId;
        this.workoutId     = workoutId;
        this.stepExercises = stepExercises;
    }

    public static StepResponse fromAggregate(Step entity) {
        return new StepResponse(entity.id().value(), entity.description().value(), entity.stepTypeId().value(), entity.workoutId().value());
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
