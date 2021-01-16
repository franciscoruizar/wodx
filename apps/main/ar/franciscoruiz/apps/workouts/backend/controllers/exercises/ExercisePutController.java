package ar.franciscoruiz.apps.workouts.backend.controllers.exercises;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.exercises.application.create.CreateExerciseCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ExercisePutController extends ApiController {
    public ExercisePutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/exercises/{id}")
    public ResponseEntity<String> index(
        @RequestParam String id,
        @RequestBody ExerciseRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateExerciseCommand(
                id,
                request.description(),
                request.mediaUrl()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
