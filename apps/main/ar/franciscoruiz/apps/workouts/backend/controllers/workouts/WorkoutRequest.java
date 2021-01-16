package ar.franciscoruiz.apps.workouts.backend.controllers.workouts;

import java.time.LocalDateTime;

public final class WorkoutRequest {
    private String        id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String        coachId;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime startDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime endDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String coachId() {
        return this.coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }
}
