package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class AuthenticationsUserFinderDomain {
    private final AuthenticationsUserRepository repository;

    public AuthenticationsUserFinderDomain(AuthenticationsUserRepository repository) {
        this.repository = repository;
    }

    public AuthenticationsUser find(UserId id) {
        return this.repository.search(id)
            .orElseThrow(() -> new AuthenticationsUserNotExist(id));
    }
}
