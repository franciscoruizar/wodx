package ar.franciscoruiz.accounts.permissions.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository {
    Optional<Permission> search(PermissionId id);

    List<Permission> matching(Criteria criteria);
}
