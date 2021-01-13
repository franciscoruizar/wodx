package ar.franciscoruiz.workouts.steps.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.workouts.step_exercises.application.StepExercisesResponse;
import ar.franciscoruiz.workouts.step_exercises.application.search_by_criteria.SearchStepExercisesByCriteriaQuery;
import ar.franciscoruiz.workouts.steps.application.StepResponse;
import ar.franciscoruiz.workouts.steps.domain.StepId;
import ar.franciscoruiz.workouts.steps.domain.StepNotExist;
import ar.franciscoruiz.workouts.steps.domain.StepRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public final class StepFinder {
    private final StepRepository repository;
    private final QueryBus       queryBus;

    public StepFinder(StepRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public StepResponse find(StepId id) throws StepNotExist {
        StepExercisesResponse stepExercises = searchStepExercises(id);

        return repository.search(id)
            .map((step) ->
                new StepResponse(
                    step.id().value(),
                    step.description().value(),
                    step.stepTypeId().value(),
                    step.workoutId().value(),
                    stepExercises
                )
            )
            .orElseThrow(() -> new StepNotExist(id));
    }

    private StepExercisesResponse searchStepExercises(StepId id) {
        List<HashMap<String, String>> filters = new ArrayList<>() {{
            add(new HashMap<>() {{
                put("field", "workout_id");
                put("operator", "=");
                put("value", id.value());
            }});
        }};

        return this.queryBus.ask(new SearchStepExercisesByCriteriaQuery(filters, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
    }
}
