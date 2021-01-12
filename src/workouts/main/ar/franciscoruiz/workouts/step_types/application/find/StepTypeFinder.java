package ar.franciscoruiz.workouts.step_types.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.workouts.step_types.application.StepTypeResponse;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeNotExist;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeRepository;

@Service
public final class StepTypeFinder {
    private final StepTypeRepository repository;

    public StepTypeFinder(StepTypeRepository repository) {
        this.repository = repository;
    }

    public StepTypeResponse find(StepTypeId id) throws StepTypeNotExist {
        return repository.search(id)
                         .map(StepTypeResponse::fromAggregate)
                         .orElseThrow(() -> new StepTypeNotExist(id));
    }
}
