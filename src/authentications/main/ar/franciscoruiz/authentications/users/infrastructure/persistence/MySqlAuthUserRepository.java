package ar.franciscoruiz.authentications.users.infrastructure.persistence;

import ar.franciscoruiz.authentications.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
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
    public Optional<User> search(UserEmail email) {
        Session session = sessionFactory.openSession();
        String  sql     = String.format("SELECT id, name, surname, email, password, password, phone, is_active, role_id FROM users WHERE email='%s'", email.value());
        Query   query   = session.createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        session.close();

        Object[] user = result.get(0);

        if (user == null) {
            return Optional.empty();
        }

        return Optional.of(new User(
            new UserId((String) user[0]),
            new UserName((String) user[1]),
            new UserSurname((String) user[2]),
            new UserEmail((String) user[3]),
            new UserPassword((String) user[4]),
            new UserPhone((String) user[5]),
            new UserIsActive((boolean) user[6]),
            new RoleId((String) user[7])
        ));
    }

    @Override
    public Optional<User> search(UserId id) {
        return byId(id);
    }
}
