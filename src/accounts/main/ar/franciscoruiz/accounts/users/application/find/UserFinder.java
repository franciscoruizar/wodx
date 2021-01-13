package ar.franciscoruiz.accounts.users.application.find;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.domain.UserNotExist;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserFinder {
    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse find(UserId id) {
        return this.repository.search(id)
            .map(UserResponse::fromAggregate)
            .orElseThrow(() -> new UserNotExist(id));
    }
}
