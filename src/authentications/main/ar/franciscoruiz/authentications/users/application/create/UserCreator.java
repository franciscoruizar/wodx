package ar.franciscoruiz.authentications.users.application.create;

import ar.franciscoruiz.authentications.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserCreator {
    private final AuthUserRepository repository;
    private final UserFinderDomain   finder;

    public UserCreator(AuthUserRepository repository, UserFinderDomain finder) {
        this.repository = repository;
        this.finder     = finder;
    }

    public void create(
        UserId id,
        UserName name,
        UserSurname surname,
        UserEmail email,
        UserPhone phone,
        UserIsActive isActive,
        RoleId roleId
    ) {
        ensureExistsUser(id);

        var user = new User(id, name, surname, email, new UserPassword(""), phone, isActive, roleId);

        this.repository.save(user);
    }

    private void ensureExistsUser(UserId id) {
        this.finder.find(id);
    }
}
