package ar.franciscoruiz.apps.workouts.backend.controllers.exercises;

public final class ExerciseRequest {
    private String id;
    private String description;
    private String mediaUrl;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String description() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String mediaUrl() {
        return this.mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
