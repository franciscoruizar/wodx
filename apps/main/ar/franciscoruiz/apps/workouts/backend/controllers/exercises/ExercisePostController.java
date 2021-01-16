package ar.franciscoruiz.apps.workouts.backend.controllers.exercises;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.exercises.application.create.CreateExerciseCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ExercisePostController extends ApiController {
    public ExercisePostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/exercises")
    public ResponseEntity<String> index(
        @RequestBody ExerciseRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateExerciseCommand(
                request.id(),
                request.description(),
                request.mediaUrl()
            )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
