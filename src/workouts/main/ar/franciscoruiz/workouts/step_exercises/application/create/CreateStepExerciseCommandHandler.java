package ar.franciscoruiz.workouts.step_exercises.application.create;

import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.media.MediaUploader;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseId;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseSeries;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseTimeUnit;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseValue;
import ar.franciscoruiz.workouts.steps.domain.StepId;

public final class CreateStepExerciseCommandHandler implements CommandHandler<CreateStepExerciseCommand> {
    private final StepExerciseCreator creator;
    private final MediaUploader       mediaUploader;

    public CreateStepExerciseCommandHandler(StepExerciseCreator creator, MediaUploader mediaUploader) {
        this.creator       = creator;
        this.mediaUploader = mediaUploader;
    }

    @Override
    public void handle(CreateStepExerciseCommand command) {

        StepExerciseId       id         = new StepExerciseId(command.id());
        StepExerciseSeries   series     = new StepExerciseSeries(command.series());
        StepExerciseValue    value      = new StepExerciseValue(command.value());
        StepExerciseTimeUnit timeUnit   = StepExerciseTimeUnit.valueOf(command.timeUnit());
        StepId               stepId     = new StepId(command.stepId());
        ExerciseId           exerciseId = new ExerciseId(command.exerciseId());

        this.creator.create(id, series, value, timeUnit, stepId, exerciseId);
    }
}
