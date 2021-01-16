package ar.franciscoruiz.apps.workouts.backend.controllers.exercises;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.exercises.application.ExerciseResponse;
import ar.franciscoruiz.workouts.exercises.application.find.FindExerciseQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class ExerciseGetController extends ApiController {
    public ExerciseGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/exercises/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        ExerciseResponse response = ask(new FindExerciseQuery(id));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", response.id());
            put("description", response.description());
            put("mediaUrl", response.mediaUrl());
        }});
    }
}
