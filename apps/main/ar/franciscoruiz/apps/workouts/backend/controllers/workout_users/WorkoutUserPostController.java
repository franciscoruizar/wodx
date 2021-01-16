package ar.franciscoruiz.apps.workouts.backend.controllers.workout_users;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.workout_users.application.create.CreateWorkoutUserCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class WorkoutUserPostController extends ApiController {
    public WorkoutUserPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/workouts/users")
    public ResponseEntity<String> index(
        @RequestBody WorkoutUserRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateWorkoutUserCommand(
                request.id(),
                request.workoutId(),
                request.athleteId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
