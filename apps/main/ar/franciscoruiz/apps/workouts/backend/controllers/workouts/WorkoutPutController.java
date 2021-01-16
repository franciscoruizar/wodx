package ar.franciscoruiz.apps.workouts.backend.controllers.workouts;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.workouts.application.create.CreateWorkoutCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class WorkoutPutController extends ApiController {
    public WorkoutPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/workouts/{id}")
    public ResponseEntity<String> index(
        @RequestParam String id,
        @RequestBody WorkoutRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateWorkoutCommand(
                id,
                request.startDate(),
                request.endDate(),
                request.coachId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
