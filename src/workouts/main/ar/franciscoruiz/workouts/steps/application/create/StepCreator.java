package ar.franciscoruiz.workouts.steps.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.steps.domain.Step;
import ar.franciscoruiz.workouts.steps.domain.StepDescription;
import ar.franciscoruiz.workouts.steps.domain.StepId;
import ar.franciscoruiz.workouts.steps.domain.StepRepository;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;

@Service
public final class StepCreator {
    private final StepRepository repository;

    public StepCreator(StepRepository repository) {
        this.repository = repository;
    }

    public void create(StepId id, StepDescription description, StepTypeId stepTypeId, WorkoutId workoutId) {
        Step step = new Step(id, description, stepTypeId, workoutId);

        this.repository.save(step);
    }
}
