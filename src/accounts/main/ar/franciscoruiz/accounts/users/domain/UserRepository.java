package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> search(UserId id);

    List<User> matching(Criteria criteria);
}
