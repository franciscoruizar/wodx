package ar.franciscoruiz.accounts.sign_up.infrastructure.persistence;

import ar.franciscoruiz.accounts.sign_up.domain.SignUpUser;
import ar.franciscoruiz.accounts.sign_up.domain.SignUpUserRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("accounts-transaction_manager")
public final class MySqlSignUpUserRepository extends HibernateRepository<SignUpUser> implements SignUpUserRepository {
    public MySqlSignUpUserRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, SignUpUser.class);
    }

    @Override
    public void save(SignUpUser user) {
        persist(user);
    }
}
