package ar.franciscoruiz.authentications.users.infrastructure.persistence;

import ar.franciscoruiz.authentications.users.domain.AuthUserRepository;
import ar.franciscoruiz.authentications.users.domain.User;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

@Service
public final class MySqlAuthUserRepository extends HibernateRepository<User> implements AuthUserRepository {
    public MySqlAuthUserRepository(@Qualifier("authentications-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public Optional<User> search(UserId id) {
        return byId(id);
    }
}
