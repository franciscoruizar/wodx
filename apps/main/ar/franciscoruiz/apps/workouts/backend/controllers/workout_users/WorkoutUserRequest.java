package ar.franciscoruiz.apps.workouts.backend.controllers.workout_users;

public final class WorkoutUserRequest {
    private String id;
    private String workoutId;
    private String athleteId;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String workoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public String athleteId() {
        return this.athleteId;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId;
    }
}
