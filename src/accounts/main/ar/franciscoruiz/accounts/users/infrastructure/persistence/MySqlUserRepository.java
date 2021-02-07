package ar.franciscoruiz.accounts.users.infrastructure.persistence;

import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserEmail;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public Optional<User> search(UserEmail email) {
        Session session = sessionFactory.openSession();
        String  sql     = String.format("SELECT id, name, surname, email, phone, is_active, role_id FROM users WHERE email='%s'", email.value());
        Query   query   = session.createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        session.close();

        Object[] user = result.get(0);

        if (user == null) {
            return Optional.empty();
        }

        return Optional.of(new User(
            (String) user[0],
            (String) user[1],
            (String) user[2],
            (String) user[3],
            (String) user[5],
            (boolean) user[6],
            (String) user[7]
        ));
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
