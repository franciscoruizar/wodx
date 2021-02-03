package ar.franciscoruiz.authentications.auth.application.authenticate;


import ar.franciscoruiz.authentications.auth.domain.AuthRepository;
import ar.franciscoruiz.authentications.auth.domain.InvalidAuthCredentials;
import ar.franciscoruiz.authentications.auth.domain.InvalidAuthUsername;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;

import java.util.Optional;

@Service
public final class AuthUserAuthenticator {
    private final AuthRepository  repository;
    private final PasswordEncoder encoder;

    public AuthUserAuthenticator(AuthRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder    = encoder;
    }

    public void authenticate(AuthEmail email, AuthPassword password) {
        Optional<AuthUser> auth = repository.search(email);

        ensureUserExist(auth, email);
        ensureCredentialsAreValid(auth.get(), password);
    }

    private void ensureUserExist(Optional<AuthUser> auth, AuthEmail email) {
        if (auth.isEmpty()) {
            throw new InvalidAuthUsername(email);
        }
    }

    private void ensureCredentialsAreValid(AuthUser auth, AuthPassword password) {
        if (!encoder.matches(password.value(), auth.password().value())) {
            throw new InvalidAuthCredentials(auth.email());
        }
    }
}
