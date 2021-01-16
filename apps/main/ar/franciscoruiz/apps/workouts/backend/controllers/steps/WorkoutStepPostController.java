package ar.franciscoruiz.apps.workouts.backend.controllers.steps;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.steps.application.create.CreateStepCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class WorkoutStepPostController extends ApiController {
    public WorkoutStepPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/workouts/steps")
    public ResponseEntity<String> index(
        @RequestBody StepRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateStepCommand(
                request.id(),
                request.description(),
                request.stepTypeId(),
                request.workoutId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
