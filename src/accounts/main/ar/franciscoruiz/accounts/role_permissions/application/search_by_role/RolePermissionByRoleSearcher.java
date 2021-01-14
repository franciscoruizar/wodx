package ar.franciscoruiz.accounts.role_permissions.application.search_by_role;

import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionResponse;
import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionsResponse;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;

import java.util.stream.Collectors;

@Service
public final class RolePermissionByRoleSearcher {
    private final RolePermissionRepository repository;

    public RolePermissionByRoleSearcher(RolePermissionRepository repository) {
        this.repository = repository;
    }

    public RolePermissionsResponse search(RoleId roleId) {
        return new RolePermissionsResponse(
            this.repository
                .searchByRole(roleId)
                .stream()
                .map(RolePermissionResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
