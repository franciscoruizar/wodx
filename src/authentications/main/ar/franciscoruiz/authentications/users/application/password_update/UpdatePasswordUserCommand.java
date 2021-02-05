package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class UpdatePasswordUserCommand implements Command {
    private final String userId;
    private final String oldPassword;
    private final String newPassword;

    public UpdatePasswordUserCommand(String userId, String oldPassword, String newPassword) {
        this.userId      = userId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String userId() {
        return userId;
    }

    public String oldPassword() {
        return oldPassword;
    }

    public String newPassword() {
        return newPassword;
    }
}
