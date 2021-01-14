package ar.franciscoruiz.accounts.roles.application.find;

import ar.franciscoruiz.accounts.permissions.application.PermissionResponse;
import ar.franciscoruiz.accounts.permissions.application.PermissionsResponse;
import ar.franciscoruiz.accounts.permissions.application.find.FindPermissionQuery;
import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionsResponse;
import ar.franciscoruiz.accounts.role_permissions.application.search_by_role.SearchRolePermissionByRoleQuery;
import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleNotExist;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;

import java.util.ArrayList;
import java.util.List;

@Service
public final class RoleFinder {
    private final RoleRepository repository;
    private final QueryBus       queryBus;

    public RoleFinder(RoleRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public RoleResponse find(RoleId id) {
        Role role = this.repository.search(id)
            .orElseThrow(() -> new RoleNotExist(id));

        PermissionsResponse permissions = searchPermissions(role);

        return RoleResponse.fromAggregate(role, permissions);
    }

    private PermissionsResponse searchPermissions(Role role) {
        RolePermissionsResponse rolePermissions = this.queryBus.ask(new SearchRolePermissionByRoleQuery(role.id().value()));

        List<PermissionResponse> permissions = new ArrayList<>();

        for (var rolePermission : rolePermissions.values()) {
            permissions.add(queryBus.ask(new FindPermissionQuery(rolePermission.permissionId())));
        }

        return new PermissionsResponse(permissions);
    }
}
