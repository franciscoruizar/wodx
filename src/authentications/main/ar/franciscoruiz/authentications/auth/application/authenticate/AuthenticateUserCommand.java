package ar.franciscoruiz.authentications.auth.application.authenticate;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class AuthenticateUserCommand implements Command {
    private final String email;
    private final String password;

    public AuthenticateUserCommand(String email, String password) {
        this.email    = email;
        this.password = password;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }
}
