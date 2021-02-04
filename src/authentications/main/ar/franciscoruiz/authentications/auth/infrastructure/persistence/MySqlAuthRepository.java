package ar.franciscoruiz.authentications.auth.infrastructure.persistence;

import ar.franciscoruiz.authentications.auth.domain.AuthRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.Authorities;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlAuthRepository extends HibernateRepository<AuthUser> implements AuthRepository {
    public MySqlAuthRepository(@Qualifier("authentications-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, AuthUser.class);
    }

    @Override
    public Optional<AuthUser> search(AuthEmail email) {
        String sql   = String.format("SELECT email, password, role_id FROM users WHERE email='%s'", email.value());
        Query  query = sessionFactory.getCurrentSession().createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        String sqlRole   = String.format("SELECT description FROM roles WHERE id='%s'", result.get(0)[2]);
        Query  queryRole = sessionFactory.getCurrentSession().createNativeQuery(sqlRole);

        List<String> resultRoles = queryRole.getResultList();

        return Optional.of(new AuthUser(
            new AuthEmail((String) result.get(0)[0]),
            new AuthPassword((String) result.get(0)[1]),
            new Authorities(resultRoles)
        ));
    }
}
