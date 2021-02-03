package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.authentications.users.domain.UserPassword;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UpdatePasswordAuthUserCommandHandler implements CommandHandler<UpdatePasswordAuthUserCommand> {
    private final PasswordAuthUserUpdater creator;

    public UpdatePasswordAuthUserCommandHandler(PasswordAuthUserUpdater creator) {
        this.creator = creator;
    }

    @Override
    public void handle(UpdatePasswordAuthUserCommand command) {
        UserId       id          = new UserId(command.id());
        UserPassword oldPassword = new UserPassword(command.oldPassword());
        UserPassword newPassword = new UserPassword(command.newPassword());

        this.creator.update(id, oldPassword, newPassword);
    }
}
