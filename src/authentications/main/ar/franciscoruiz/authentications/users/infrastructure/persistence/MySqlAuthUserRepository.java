package ar.franciscoruiz.authentications.users.infrastructure.persistence;

import ar.franciscoruiz.authentications.users.domain.User;
import ar.franciscoruiz.authentications.users.domain.AuthUserRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Service
public final class MySqlAuthUserRepository extends HibernateRepository<User> implements AuthUserRepository {
    public MySqlAuthUserRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, User.class, "authentications");
    }

    @Override
    public Optional<User> search(UserId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id.value()));
    }

    @Override
    public void save(User user) {
        persist(user);
    }
}
