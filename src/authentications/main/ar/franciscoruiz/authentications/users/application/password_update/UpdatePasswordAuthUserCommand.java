package ar.franciscoruiz.authentications.users.application.password_update;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class UpdatePasswordAuthUserCommand implements Command {
    private final String id;
    private final String oldPassword;
    private final String newPassword;

    public UpdatePasswordAuthUserCommand(String id, String oldPassword, String newPassword) {
        this.id          = id;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String id() {
        return id;
    }

    public String oldPassword() {
        return oldPassword;
    }

    public String newPassword() {
        return newPassword;
    }
}
