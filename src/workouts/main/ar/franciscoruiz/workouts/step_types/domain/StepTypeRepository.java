package ar.franciscoruiz.workouts.step_types.domain;

import java.util.Optional;

public interface StepTypeRepository {
    Optional<StepType> search(StepTypeId id);
}

