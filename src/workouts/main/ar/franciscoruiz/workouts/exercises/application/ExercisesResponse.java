package ar.franciscoruiz.workouts.exercises.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class ExercisesResponse implements Response {
    private final List<ExerciseResponse> values;

    public ExercisesResponse(List<ExerciseResponse> values) {
        this.values = values;
    }

    public List<ExerciseResponse> values() {
        return this.values;
    }
}
