package ar.franciscoruiz.accounts.role_permissions.infrastructure.persistence;

import ar.franciscoruiz.accounts.permissions.domain.PermissionId;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermission;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionId;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<RolePermission> searchByRole(RoleId roleId) {
        String sql   = String.format("SELECT * FROM role_permissions WHERE role_id='%s'", roleId.value());
        Query  query = sessionFactory.getCurrentSession().createNativeQuery(sql);

        List<Object[]> resultList = query.getResultList();

        List<RolePermission> rolePermissions = new ArrayList<>();

        for (Object[] result : resultList) {
            rolePermissions.add(new RolePermission(
                new RolePermissionId((String) result[0]),
                new RoleId((String) result[2]),
                new PermissionId((String) result[1])
            ));
        }

        return rolePermissions;
    }
}
