package ar.franciscoruiz.apps.workouts.backend.controllers.workouts;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.workouts.application.create.CreateWorkoutCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class WorkoutPostController extends ApiController {
    public WorkoutPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/workouts")
    public ResponseEntity<String> index(
        @RequestBody WorkoutRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateWorkoutCommand(
                request.id(),
                request.startDate(),
                request.endDate(),
                request.coachId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
