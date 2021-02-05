package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.authentications.users.domain.UserPassword;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UpdatePasswordUserCommandHandler implements CommandHandler<UpdatePasswordUserCommand> {
    private final PasswordUserUpdater creator;

    public UpdatePasswordUserCommandHandler(PasswordUserUpdater creator) {
        this.creator = creator;
    }

    @Override
    public void handle(UpdatePasswordUserCommand command) {
        UserId       userId      = new UserId(command.userId());
        UserPassword oldPassword = new UserPassword(command.oldPassword());
        UserPassword newPassword = new UserPassword(command.newPassword());

        this.creator.update(userId, oldPassword, newPassword);
    }
}
