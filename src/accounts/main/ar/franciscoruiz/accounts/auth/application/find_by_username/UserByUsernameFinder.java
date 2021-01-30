package ar.franciscoruiz.accounts.auth.application.find_by_username;


import ar.franciscoruiz.accounts.auth.domain.AuthRepository;
import ar.franciscoruiz.accounts.auth.domain.InvalidAuthCredentials;
import ar.franciscoruiz.accounts.auth.domain.InvalidAuthUsername;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthUser;

import java.util.Optional;

@Service
public final class UserByUsernameFinder {
    private final AuthRepository repository;

    public UserByUsernameFinder(AuthRepository repository) {
        this.repository = repository;
    }

    public UserDetailsResponse find(AuthEmail email) {
        AuthUser auth = repository.search(email).orElseThrow(() -> new InvalidAuthCredentials(email));

        return new UserDetailsResponse(auth.email().value(), auth.password().value(), auth.authorities().values());
    }
}
