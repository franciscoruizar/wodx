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
public final class MySqlAuthenticationsUserRepository extends HibernateRepository<AuthenticationsUser> implements AuthenticationsUserRepository {
    public MySqlAuthenticationsUserRepository(@Qualifier("authentications-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, AuthenticationsUser.class);
    }

    @Override
    public void save(AuthenticationsUser user) {
        persist(user);
    }

    @Override
    public Optional<AuthenticationsUser> search(AuthenticationsUserEmail email) {
        Session session = sessionFactory.openSession();
        String  sql     = String.format("SELECT id, name, surname, email, password, password, phone, is_active, role_id FROM users WHERE email='%s'", email.value());
        Query   query   = session.createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        session.close();

        Object[] user = result.get(0);

        if (user == null) {
            return Optional.empty();
        }

        return Optional.of(new AuthenticationsUser(
            new UserId((String) user[0]),
            new AuthenticationsUserName((String) user[1]),
            new AuthenticationsUserSurname((String) user[2]),
            new AuthenticationsUserEmail((String) user[3]),
            new AuthenticationsUserPassword((String) user[4]),
            new AuthenticationsUserPhone((String) user[5]),
            new AuthenticationsUserIsActive((boolean) user[6]),
            new RoleId((String) user[7])
        ));
    }

    @Override
    public Optional<AuthenticationsUser> search(UserId id) {
        return byId(id);
    }
}
