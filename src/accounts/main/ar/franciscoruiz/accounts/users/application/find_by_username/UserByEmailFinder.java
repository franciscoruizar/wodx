package ar.franciscoruiz.accounts.users.application.find_by_username;


import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserEmail;
import ar.franciscoruiz.accounts.users.domain.UserNotExist;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserByEmailFinder {
    private final UserRepository repository;

    public UserByEmailFinder(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse find(UserEmail email) {
        User user = repository.search(email).orElseThrow(() -> new UserNotExist(email));

        return UserResponse.fromAggregate(user);
    }
}
