package ar.franciscoruiz.authentications.users.application.find_by_username;


import ar.franciscoruiz.authentications.users.domain.AuthUserRepository;
import ar.franciscoruiz.authentications.users.domain.User;
import ar.franciscoruiz.authentications.users.domain.UserEmail;
import ar.franciscoruiz.authentications.users.domain.UserNotExist;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.roles.Role;

@Service
public final class UserByEmailFinder {
    private final AuthUserRepository repository;

    public UserByEmailFinder(AuthUserRepository repository) {
        this.repository = repository;
    }

    public UserResponse find(UserEmail email) {
        User user = repository.search(email).orElseThrow(() -> new UserNotExist(email));

        return new UserResponse(
            user.id().value(),
            user.name().value(),
            user.surname().value(),
            user.email().value(),
            user.phone().value(),
            user.isActive().value(),
            Role.valueOf(user.roleId().value()).name()
        );
    }
}
