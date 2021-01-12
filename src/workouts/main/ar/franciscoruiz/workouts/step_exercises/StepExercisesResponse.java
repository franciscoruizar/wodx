package ar.franciscoruiz.workouts.step_exercises;

import ar.franciscoruiz.shared.domain.bus.query.Response;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;
import ar.franciscoruiz.workouts.step_exercises.application.StepExerciseResponse;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExercise;

import java.util.List;

public final class StepExercisesResponse implements Response {
    private final List<StepExerciseResponse> values;

    public StepExercisesResponse(List<StepExerciseResponse> values) {
        this.values = values;
    }

    public List<StepExerciseResponse> values() {
        return this.values;
    }
}
