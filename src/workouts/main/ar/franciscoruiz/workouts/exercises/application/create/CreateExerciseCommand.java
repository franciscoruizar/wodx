package ar.franciscoruiz.workouts.exercises.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateExerciseCommand implements Command {
    private final String id;
    private final String description;
    private final String base64;

    public CreateExerciseCommand(String id, String description, String base64) {
        this.id          = id;
        this.description = description;
        this.base64      = base64;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public String base64() {
        return this.base64;
    }
}
