package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserPassword;
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
        UserId                      userId      = new UserId(command.userId());
        AuthenticationsUserPassword oldPassword = new AuthenticationsUserPassword(command.oldPassword());
        AuthenticationsUserPassword newPassword = new AuthenticationsUserPassword(command.newPassword());

        this.creator.update(userId, oldPassword, newPassword);
    }
}
