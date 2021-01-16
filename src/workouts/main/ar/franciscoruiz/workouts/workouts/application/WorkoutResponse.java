package ar.franciscoruiz.workouts.workouts.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.time.LocalDateTime;

public final class WorkoutResponse implements Response {
    private final String        id;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String        coachId;

    public WorkoutResponse(String id, LocalDateTime startDate, LocalDateTime endDate, String coachId) {
        this.id        = id;
        this.startDate = startDate;
        this.endDate   = endDate;
        this.coachId   = coachId;
    }

    public String id() {
        return this.id;
    }

    public LocalDateTime startDate() {
        return this.startDate;
    }

    public LocalDateTime endDate() {
        return this.endDate;
    }

    public String coachId() {
        return this.coachId;
    }
}
