package ar.franciscoruiz.workouts.exercises.domain;

import java.util.Objects;

public final class Exercise {
    private final ExerciseId          id;
    private final ExerciseDescription description;
    private final ExerciseMediaUrl    mediaUrl;

    public Exercise(ExerciseId id, ExerciseDescription description, ExerciseMediaUrl mediaUrl) {
        this.id          = id;
        this.description = description;
        this.mediaUrl    = mediaUrl;
    }

    public Exercise() {
        this.id          = null;
        this.description = null;
        this.mediaUrl    = null;
    }

    public ExerciseId id() {
        return this.id;
    }

    public ExerciseDescription description() {
        return this.description;
    }

    public ExerciseMediaUrl mediaUrl() {
        return this.mediaUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id) && Objects.equals(description, exercise.description) && Objects.equals(mediaUrl, exercise.mediaUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, mediaUrl);
    }
}
