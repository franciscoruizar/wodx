package ar.franciscoruiz.authentications.users.application.register;

import ar.franciscoruiz.authentications.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserRegister {
    private final AuthenticationsUserRepository   repository;
    private final AuthenticationsUserFinderDomain finder;

    public UserRegister(AuthenticationsUserRepository repository, AuthenticationsUserFinderDomain finder) {
        this.repository = repository;
        this.finder     = finder;
    }

    public void create(
        UserId id,
        AuthenticationsUserName name,
        AuthenticationsUserSurname surname,
        AuthenticationsUserEmail email,
        AuthenticationsUserPhone phone,
        RoleId roleId
    ) {
        ensureNonExistsUser(id);

        var user = new AuthenticationsUser(id, name, surname, email, new AuthenticationsUserPassword(""), phone, new AuthenticationsUserIsActive(true), roleId);

        this.repository.save(user);
    }

    private void ensureNonExistsUser(UserId id) {
        try {
            this.finder.find(id);

            throw new AuthenticationsUserExists();
        } catch (AuthenticationsUserNotExist ignored) {
        }
    }
}
