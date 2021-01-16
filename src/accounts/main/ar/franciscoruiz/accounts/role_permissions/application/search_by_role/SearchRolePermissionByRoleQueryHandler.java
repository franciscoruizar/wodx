package ar.franciscoruiz.accounts.role_permissions.application.search_by_role;

import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionsResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchRolePermissionByRoleQueryHandler implements QueryHandler<SearchRolePermissionByRoleQuery, RolePermissionsResponse> {
    private final RolePermissionByRoleSearcher searcher;

    public SearchRolePermissionByRoleQueryHandler(RolePermissionByRoleSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public RolePermissionsResponse handle(SearchRolePermissionByRoleQuery query) {
        RoleId roleId = new RoleId(query.id());

        return searcher.search(roleId);
    }
}
