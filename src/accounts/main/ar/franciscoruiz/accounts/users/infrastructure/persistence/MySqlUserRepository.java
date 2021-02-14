package ar.franciscoruiz.accounts.users.infrastructure.persistence;

import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MySqlUserRepository extends HibernateRepository<User> implements UserRepository {
    public MySqlUserRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public Optional<User> search(String id) {
        return byId(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Filter   filter   = new Filter(new FilterField("email"), FilterOperator.EQUAL, new FilterValue(email));
        Filters  filters  = new Filters(Collections.singletonList(filter));
        Criteria criteria = new Criteria(filters, Order.none());

        return byCriteria(criteria).stream().findFirst();
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
