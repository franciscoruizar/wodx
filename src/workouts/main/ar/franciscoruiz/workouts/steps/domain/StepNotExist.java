package ar.franciscoruiz.workouts.steps.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class StepNotExist extends DomainError {
    public StepNotExist(StepId id) {
        super("step_not_exist", String.format("The step <%s> doesn't exist", id.value()));
    }
}
