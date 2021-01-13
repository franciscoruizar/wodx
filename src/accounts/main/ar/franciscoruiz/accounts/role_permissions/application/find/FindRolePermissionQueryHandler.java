package ar.franciscoruiz.accounts.role_permissions.application.find;

import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionResponse;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindRolePermissionQueryHandler implements QueryHandler<FindRolePermissionQuery, RolePermissionResponse> {
    private final RolePermissionFinder finder;

    public FindRolePermissionQueryHandler(RolePermissionFinder finder) {
        this.finder = finder;
    }

    @Override
    public RolePermissionResponse handle(FindRolePermissionQuery query) {
        RolePermissionId id = new RolePermissionId(query.id());

        return this.finder.find(id);
    }
}
