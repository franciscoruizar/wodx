package ar.franciscoruiz.apps.workouts.backend.controllers.exercises;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.exercises.application.ExercisesResponse;
import ar.franciscoruiz.workouts.exercises.application.search_by_criteria.SearchExercisesByCriteriaQuery;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class ExercisesGetController extends ApiController {
    public ExercisesGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/exercises")
    public List<HashMap<String, Object>> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
        ExercisesResponse response = ask(new SearchExercisesByCriteriaQuery(
            parseFilters(params),
            Optional.ofNullable((String) params.get("order_by")),
            Optional.ofNullable((String) params.get("order")),
            Optional.ofNullable((Integer) params.get("limit")),
            Optional.ofNullable((Integer) params.get("offset"))
        ));

        return response.values().stream().map(exercise -> new HashMap<String, Object>() {{
            put("id", exercise.id());
            put("description", exercise.description());
            put("mediaUrl", exercise.mediaUrl());
        }}).collect(Collectors.toList());
    }
}
