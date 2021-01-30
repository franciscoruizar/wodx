package ar.franciscoruiz.accounts.users.application.create;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserCreator {
    private final UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void create(
        UserId id,
        UserName name,
        UserSurname surname,
        UserEmail email,
        UserPassword password,
        UserPhone phone,
        UserIsActive isActive,
        RoleId roleId
    ) {
        var user = new User(
            id.value(),
            name.value(),
            surname.value(),
            email.value(),
            password.value(),
            phone.value(),
            isActive.value(),
            roleId.value()
        );

        this.repository.save(user);
    }
}
