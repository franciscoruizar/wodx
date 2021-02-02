package ar.franciscoruiz.accounts.roles.infrastructure.persistence;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("accounts-transaction_manager")
public final class MySqlRoleRepository extends HibernateRepository<Role> implements RoleRepository {
    public MySqlRoleRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Role.class);
    }

    @Override
    public Optional<Role> search(RoleId id) {
        return byId(id);
    }

    @Override
    public List<Role> findAll() {
        return all();
    }
}
