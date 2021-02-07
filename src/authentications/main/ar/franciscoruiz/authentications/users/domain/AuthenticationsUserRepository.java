package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.Optional;

public interface AuthenticationsUserRepository {
    void save(AuthenticationsUser user);

    Optional<AuthenticationsUser> search(AuthenticationsUserEmail email);

    Optional<AuthenticationsUser> search(UserId id);
}
