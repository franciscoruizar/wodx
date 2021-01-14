package ar.franciscoruiz.accounts.roles.application.search_all;

import ar.franciscoruiz.accounts.permissions.application.PermissionResponse;
import ar.franciscoruiz.accounts.permissions.application.PermissionsResponse;
import ar.franciscoruiz.accounts.permissions.application.find.FindPermissionQuery;
import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionsResponse;
import ar.franciscoruiz.accounts.role_permissions.application.search_by_role.SearchRolePermissionByRoleQuery;
import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.application.RolesResponse;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AllRolesSearcher {
    private final RoleRepository repository;
    private final QueryBus       queryBus;

    public AllRolesSearcher(RoleRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public RolesResponse search() {
        return new RolesResponse(
            this.repository.findAll()
                .stream()
                .map(role -> {
                    PermissionsResponse permissions = searchPermissions(role);

                    return RoleResponse.fromAggregate(role, permissions);
                })
                .collect(Collectors.toList())
        );
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
