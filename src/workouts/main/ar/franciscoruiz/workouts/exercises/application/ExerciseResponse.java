package ar.franciscoruiz.workouts.exercises.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;
import ar.franciscoruiz.workouts.exercises.domain.Exercise;

public final class ExerciseResponse implements Response {
    private final String id;
    private final String description;
    private final String mediaUrl;

    public ExerciseResponse(String id, String description, String mediaUrl) {
        this.id          = id;
        this.description = description;
        this.mediaUrl    = mediaUrl;
    }

    public static ExerciseResponse fromAggregate(Exercise entity) {
        return new ExerciseResponse(entity.id().value(), entity.description().value(), entity.mediaUrl().value());
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public String mediaUrl() {
        return this.mediaUrl;
    }
}
