package ar.franciscoruiz.accounts.users.infrastructure.persistence;

import ar.franciscoruiz.accounts.user_memberships.domain.UserMembership;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MySqlUserRepository extends HibernateRepository<User> implements UserRepository {
    public MySqlUserRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, User.class, "accounts");
    }

    @Override
    public Optional<User> search(UserId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id.value()));
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public List<User> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
