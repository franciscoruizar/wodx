package ar.franciscoruiz.authentications.auth.infrastructure.persistence;

import ar.franciscoruiz.authentications.auth.domain.AuthRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.Authorities;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlAuthRepository extends HibernateRepository<AuthUser> implements AuthRepository {
    public MySqlAuthRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, AuthUser.class, "authentications");
    }

    @Override
    public Optional<AuthUser> search(AuthEmail email) {
        try {
            super.openSession();

            String sql   = String.format("SELECT email, password, role_id FROM users WHERE email='%s'", email.value());
            Query  query = super.session().createNativeQuery(sql);

            List<Object[]> result = query.getResultList();

            String sqlRole   = String.format("SELECT description FROM roles WHERE id='%s'", result.get(0)[2]);
            Query  queryRole = super.session().createNativeQuery(sqlRole);

            List<String> resultRoles = queryRole.getResultList();

            return Optional.of(new AuthUser(
                new AuthEmail((String) result.get(0)[0]),
                new AuthPassword((String) result.get(0)[1]),
                new Authorities(resultRoles)
            ));

        } catch (Exception e) {
            logger.warning(e.getMessage());
            e.printStackTrace();
        } finally {
            super.closeSession();
        }

        return Optional.empty();
    }
}
