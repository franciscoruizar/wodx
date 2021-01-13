package ar.franciscoruiz.accounts.role_permissions.application.find;

import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionResponse;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionId;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionNotExist;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class RolePermissionFinder {
    private final RolePermissionRepository repository;

    public RolePermissionFinder(RolePermissionRepository repository) {
        this.repository = repository;
    }

    public RolePermissionResponse find(RolePermissionId id) {
        return this.repository.search(id)
            .map(RolePermissionResponse::fromAggregate)
            .orElseThrow(() -> new RolePermissionNotExist(id));
    }
}
