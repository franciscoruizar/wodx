package ar.franciscoruiz.workouts.workout_users.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateWorkoutUserCommand implements Command {
    private final String id;
    private final String workoutId;
    private final String athleteId;

    public CreateWorkoutUserCommand(String id, String workoutId, String athleteId) {
        this.id        = id;
        this.workoutId = workoutId;
        this.athleteId = athleteId;
    }

    public String id() {
        return this.id;
    }

    public String workoutId() {
        return this.workoutId;
    }

    public String athleteId() {
        return this.athleteId;
    }
}
