package ar.franciscoruiz.workouts.exercises.domain;

public final class Exercise {
    private final String id;
    private final String description;
    private final String mediaUrl;

    public Exercise(String id, String description, String mediaUrl) {
        this.id          = id;
        this.description = description;
        this.mediaUrl    = mediaUrl;
    }

    public Exercise() {
        this.id          = null;
        this.description = null;
        this.mediaUrl    = null;
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
