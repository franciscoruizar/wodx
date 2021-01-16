package ar.franciscoruiz.apps.workouts.backend.controllers.step_exercises;

import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.workouts.step_exercises.application.create.CreateStepExerciseCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class WorkoutStepExercisePostController extends ApiController {
    public WorkoutStepExercisePostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/workouts/steps/exercises")
    public ResponseEntity<String> index(
        @RequestBody WorkoutStepExerciseRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateStepExerciseCommand(
                request.id(),
                request.series(),
                request.value(),
                request.timeUnit(),
                request.stepId(),
                request.exerciseId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
