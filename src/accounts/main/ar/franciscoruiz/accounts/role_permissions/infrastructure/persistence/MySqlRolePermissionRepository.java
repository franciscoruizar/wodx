package ar.franciscoruiz.accounts.role_permissions.infrastructure.persistence;

import ar.franciscoruiz.accounts.role_permissions.domain.RolePermission;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionId;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionRepository;
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
public final class MySqlRolePermissionRepository extends HibernateRepository<RolePermission> implements RolePermissionRepository {
    public MySqlRolePermissionRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, RolePermission.class);
    }

    @Override
    public Optional<RolePermission> search(RolePermissionId id) {
        return byId(id);
    }

    @Override
    public List<RolePermission> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
