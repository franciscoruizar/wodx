package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> search(String id);

    Optional<User> findByEmail(String email);

    List<User> matching(Criteria criteria);
}
