package ar.franciscoruiz.accounts.auth.infrastructure.persistence;

import ar.franciscoruiz.accounts.auth.domain.AuthPassword;
import ar.franciscoruiz.accounts.auth.domain.AuthRepository;
import ar.franciscoruiz.accounts.auth.domain.AuthUser;
import ar.franciscoruiz.accounts.auth.domain.AuthUsername;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("accounts-transaction_manager")
public final class MySqlAuthRepository extends HibernateRepository<AuthUser> implements AuthRepository {
    public MySqlAuthRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, AuthUser.class);
    }

    @Override
    public Optional<AuthUser> search(AuthUsername username) {
        String sql   = String.format("SELECT email, password FROM users WHERE email='%s'", username.value());
        Query  query = sessionFactory.getCurrentSession().createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        return Optional.of(new AuthUser(
            new AuthUsername((String) result.get(0)[0]),
            new AuthPassword((String) result.get(0)[1])
        ));
    }
}
