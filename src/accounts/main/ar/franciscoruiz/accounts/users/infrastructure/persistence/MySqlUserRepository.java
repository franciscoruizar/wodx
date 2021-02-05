package ar.franciscoruiz.accounts.users.infrastructure.persistence;

import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public class MySqlUserRepository extends HibernateRepository<User> implements UserRepository {
    public MySqlUserRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public Optional<User> search(UserId id) {
        return byId(id.value());
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
