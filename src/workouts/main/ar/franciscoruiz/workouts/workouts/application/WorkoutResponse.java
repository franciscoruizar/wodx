package ar.franciscoruiz.workouts.workouts.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;
import ar.franciscoruiz.workouts.steps.application.StepsResponse;

import java.time.LocalDateTime;
import java.util.List;

public final class WorkoutResponse implements Response {
    private final String        id;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String        coachId;
    private final StepsResponse steps;
    private final List<String>  athletes;

    public WorkoutResponse(String id, LocalDateTime startDate, LocalDateTime endDate, String coachId, StepsResponse steps, List<String> athletes) {
        this.id        = id;
        this.startDate = startDate;
        this.endDate   = endDate;
        this.coachId   = coachId;
        this.steps     = steps;
        this.athletes  = athletes;
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

    public StepsResponse steps() {
        return this.steps;
    }

    public List<String> athletes() {
        return this.athletes;
    }
}
