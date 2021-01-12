package ar.franciscoruiz.workouts.exercises.application.create;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.media.FailedUpload;
import ar.franciscoruiz.shared.domain.media.MediaUploader;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseDescription;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseMediaUrl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public final class CreateExerciseCommandHandler implements CommandHandler<CreateExerciseCommand> {
    private final ExerciseCreator creator;
    private final MediaUploader   mediaUploader;

    public CreateExerciseCommandHandler(ExerciseCreator creator, MediaUploader mediaUploader) {
        this.creator       = creator;
        this.mediaUploader = mediaUploader;
    }

    @Override
    public void handle(CreateExerciseCommand command) {

        try {
            String url = this.mediaUploader.upload(convertBase64ToByte(command.base64()));

            ExerciseId          id          = new ExerciseId(command.id());
            ExerciseDescription description = new ExerciseDescription(command.description());
            ExerciseMediaUrl    mediaUrl    = new ExerciseMediaUrl(url);

            this.creator.create(id, description, mediaUrl);
        } catch (IOException | InterruptedException | FailedUpload e) {
            e.printStackTrace();
        }
    }

    private byte[] convertBase64ToByte(String base64) {
        byte[] name = Base64.getEncoder().encode(base64.getBytes());
        return Base64.getDecoder().decode(new String(name).getBytes(StandardCharsets.UTF_8));
    }
}
