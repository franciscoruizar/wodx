package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserDomainFinder {
    private final UserRepository repository;

    public UserDomainFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User find(UserId id) {
        return this.repository.search(id)
            .orElseThrow(() -> new UserNotExist(id));
    }
}
