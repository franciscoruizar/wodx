package ar.franciscoruiz.workouts.step_types.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class StepTypeNotExist extends DomainError {
    public StepTypeNotExist(StepTypeId id) {
        super("step_type_not_exist", String.format("The step type <%s> doesn't exist", id.value()));
    }
}
