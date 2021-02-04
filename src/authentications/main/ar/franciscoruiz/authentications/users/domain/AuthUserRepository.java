package ar.franciscoruiz.authentications.users.domain;

import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.Optional;

public interface AuthUserRepository {
    void save(User user);

    Optional<User> search(UserId id);
}
