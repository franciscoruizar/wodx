package ar.franciscoruiz.authentications.users.application.register;

import ar.franciscoruiz.authentications.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserRegister {
    private final AuthUserRepository repository;
    private final UserFinderDomain   finder;

    public UserRegister(AuthUserRepository repository, UserFinderDomain finder) {
        this.repository = repository;
        this.finder     = finder;
    }

    public void create(
        UserId id,
        UserName name,
        UserSurname surname,
        UserEmail email,
        UserPhone phone,
        RoleId roleId
    ) {
        ensureNonExistsUser(id);

        var user = new User(id, name, surname, email, new UserPassword(""), phone, new UserIsActive(true), roleId);

        this.repository.save(user);
    }

    private void ensureNonExistsUser(UserId id) {
        try {
            this.finder.find(id);

            throw new UserExists();
        } catch (UserNotExist ignored) {
        }
    }
}
