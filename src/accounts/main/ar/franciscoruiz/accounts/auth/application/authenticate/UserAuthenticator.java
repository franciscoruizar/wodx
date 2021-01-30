package ar.franciscoruiz.accounts.auth.application.authenticate;


import ar.franciscoruiz.accounts.auth.domain.AuthRepository;
import ar.franciscoruiz.accounts.auth.domain.InvalidAuthCredentials;
import ar.franciscoruiz.accounts.auth.domain.InvalidAuthUsername;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;

import java.util.Optional;

@Service
public final class UserAuthenticator {
    private final AuthRepository repository;

    public UserAuthenticator(AuthRepository repository) {
        this.repository = repository;
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
        if (!auth.passwordMatches(password)) {
            throw new InvalidAuthCredentials(auth.email());
        }
    }
}
