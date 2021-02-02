package ar.franciscoruiz.authentications.auth.application.find_by_username;


import ar.franciscoruiz.authentications.auth.domain.AuthRepository;
import ar.franciscoruiz.authentications.auth.domain.InvalidAuthCredentials;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthUser;

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
