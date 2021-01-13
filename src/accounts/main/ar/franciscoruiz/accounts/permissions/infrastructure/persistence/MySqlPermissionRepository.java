package ar.franciscoruiz.accounts.permissions.infrastructure.persistence;

import ar.franciscoruiz.accounts.permissions.domain.Permission;
import ar.franciscoruiz.accounts.permissions.domain.PermissionId;
import ar.franciscoruiz.accounts.permissions.domain.PermissionRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("accounts-transaction_manager")
public final class MySqlPermissionRepository extends HibernateRepository<Permission> implements PermissionRepository {
    public MySqlPermissionRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Permission.class);
    }

    @Override
    public Optional<Permission> search(PermissionId id) {
        return byId(id);
    }

    @Override
    public List<Permission> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
