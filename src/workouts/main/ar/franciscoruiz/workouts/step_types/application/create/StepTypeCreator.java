package ar.franciscoruiz.workouts.step_types.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.workouts.step_types.domain.StepType;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeDescription;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeRepository;

@Service
public final class StepTypeCreator {
    private final StepTypeRepository repository;

    public StepTypeCreator(StepTypeRepository repository) {
        this.repository = repository;
    }

    public void create(StepTypeId id, StepTypeDescription description) {
        StepType stepType = new StepType(id.value(), description.value());

        this.repository.save(stepType);
    }
}
