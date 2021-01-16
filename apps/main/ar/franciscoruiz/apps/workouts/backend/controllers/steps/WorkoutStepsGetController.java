package ar.franciscoruiz.apps.workouts.backend.controllers.steps;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.steps.application.StepsResponse;
import ar.franciscoruiz.workouts.steps.application.search_by_criteria.SearchStepsByCriteriaQuery;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class WorkoutStepsGetController extends ApiController {
    public WorkoutStepsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/workouts/steps")
    public List<HashMap<String, Object>> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
        StepsResponse response = ask(new SearchStepsByCriteriaQuery(
            parseFilters(params),
            Optional.ofNullable((String) params.get("order_by")),
            Optional.ofNullable((String) params.get("order")),
            Optional.ofNullable((Integer) params.get("limit")),
            Optional.ofNullable((Integer) params.get("offset"))
        ));

        return response.values().stream().map(workoutStep -> new HashMap<String, Object>() {{
            put("id", workoutStep.id());
            put("description", workoutStep.description());
            put("stepTypeId", workoutStep.stepTypeId());
            put("workoutId", workoutStep.workoutId());
            put("exercises", workoutStep.stepExercises()
                .values()
                .stream()
                .map(stepExerciseResponse -> new HashMap<String, Object>() {{
                    put("id", stepExerciseResponse.id());
                    put("series", stepExerciseResponse.series());
                    put("value", stepExerciseResponse.value());
                    put("timeUnit", stepExerciseResponse.timeUnit());
                    put("stepId", stepExerciseResponse.stepId());
                    put("exercise", new HashMap<>() {{
                        put("id", stepExerciseResponse.exercise().id());
                        put("description", stepExerciseResponse.exercise().description());
                        put("mediaUrl", stepExerciseResponse.exercise().mediaUrl());
                    }});
                }})
                .collect(Collectors.toList())
            );
        }}).collect(Collectors.toList());
    }
}
