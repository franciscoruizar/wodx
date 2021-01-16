package ar.franciscoruiz.workouts.exercises.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateExerciseCommand implements Command {
    private final String id;
    private final String description;
    private final String mediaUrl;

    public CreateExerciseCommand(String id, String description, String mediaUrl) {
        this.id          = id;
        this.description = description;
        this.mediaUrl    = mediaUrl;
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
