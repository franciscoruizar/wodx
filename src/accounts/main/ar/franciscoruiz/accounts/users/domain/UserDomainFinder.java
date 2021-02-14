package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserDomainFinder {
    private final UserRepository repository;

    public UserDomainFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User find(String id) {
        return this.repository.search(id)
            .orElseThrow(() -> new UserNotExist(id));
    }
}
