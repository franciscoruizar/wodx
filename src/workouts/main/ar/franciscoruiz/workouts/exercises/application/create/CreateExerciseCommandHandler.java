package ar.franciscoruiz.workouts.exercises.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseDescription;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseMediaUrl;

@Service
public final class CreateExerciseCommandHandler implements CommandHandler<CreateExerciseCommand> {
    private final ExerciseCreator creator;

    public CreateExerciseCommandHandler(ExerciseCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateExerciseCommand command) {
        ExerciseId          id          = new ExerciseId(command.id());
        ExerciseDescription description = new ExerciseDescription(command.description());
        ExerciseMediaUrl    mediaUrl    = new ExerciseMediaUrl(command.mediaUrl());

        this.creator.create(id, description, mediaUrl);
    }
}
