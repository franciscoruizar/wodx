package ar.franciscoruiz.accounts.role_permissions.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface RolePermissionRepository {
    Optional<RolePermission> search(RolePermissionId id);

    List<RolePermission> matching(Criteria criteria);
}
