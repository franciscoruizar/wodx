package ar.franciscoruiz.authentications.auth.application.authenticate;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class AuthenticateUserCommandHandler implements CommandHandler<AuthenticateUserCommand> {
    private final UserAuthenticator authenticator;

    public AuthenticateUserCommandHandler(UserAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public void handle(AuthenticateUserCommand command) {
        AuthEmail    email    = new AuthEmail(command.email());
        AuthPassword password = new AuthPassword(command.password());

        authenticator.authenticate(email, password);
    }
}
