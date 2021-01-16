package ar.franciscoruiz.apps.workouts.backend.controllers.workouts;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.workouts.application.WorkoutResponse;
import ar.franciscoruiz.workouts.workouts.application.find.FindWorkoutQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class WorkoutGetController extends ApiController {
    public WorkoutGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/workouts/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        WorkoutResponse response = ask(new FindWorkoutQuery(id));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", response.id());
            put("startDate", response.startDate());
            put("endDate", response.endDate());
            put("coachId", response.coachId());
        }});
    }
}
