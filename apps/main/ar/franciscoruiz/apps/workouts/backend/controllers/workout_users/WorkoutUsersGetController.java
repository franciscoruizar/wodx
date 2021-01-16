package ar.franciscoruiz.apps.workouts.backend.controllers.workout_users;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.workout_users.application.WorkoutUsersResponse;
import ar.franciscoruiz.workouts.workout_users.application.search_by_criteria.SearchWorkoutUsersByCriteriaQuery;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class WorkoutUsersGetController extends ApiController {
    public WorkoutUsersGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/workouts/users")
    public List<HashMap<String, Object>> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
        WorkoutUsersResponse response = ask(new SearchWorkoutUsersByCriteriaQuery(
            parseFilters(params),
            Optional.ofNullable((String) params.get("order_by")),
            Optional.ofNullable((String) params.get("order")),
            Optional.ofNullable((Integer) params.get("limit")),
            Optional.ofNullable((Integer) params.get("offset"))
        ));

        return response.values().stream().map(workoutUser -> new HashMap<String, Object>() {{
            put("id", workoutUser.id());
            put("workoutId", workoutUser.workoutId());
            put("athleteId", workoutUser.athleteId());
        }}).collect(Collectors.toList());
    }
}
