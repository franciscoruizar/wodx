package ar.franciscoruiz.authentications.auth.application.find_by_username;


import ar.franciscoruiz.authentications.auth.domain.AuthRepository;
import ar.franciscoruiz.authentications.auth.domain.InvalidAuthCredentials;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthUser;

@Service
public final class AuthUserByEmailFinder {
    private final AuthRepository repository;

    public AuthUserByEmailFinder(AuthRepository repository) {
        this.repository = repository;
    }

    public AuthUserDetailsResponse find(AuthEmail email) {
        AuthUser auth = repository.search(email).orElseThrow(() -> new InvalidAuthCredentials(email));

        return new AuthUserDetailsResponse(auth.email().value(), auth.password().value(), auth.authorities().values());
    }
}
