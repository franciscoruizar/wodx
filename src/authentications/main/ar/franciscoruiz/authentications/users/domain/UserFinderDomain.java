package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserFinderDomain {
    private final UserRepository repository;

    public UserFinderDomain(UserRepository repository) {
        this.repository = repository;
    }

    public User find(UserId id) {
        return this.repository.search(id)
            .orElseThrow(() -> new UserNotExist(id));
    }
}
