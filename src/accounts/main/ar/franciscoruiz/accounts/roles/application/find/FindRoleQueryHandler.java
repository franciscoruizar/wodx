package ar.franciscoruiz.accounts.roles.application.find;

import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.roles.RoleId;

@Service
public final class FindRoleQueryHandler implements QueryHandler<FindRoleQuery, RoleResponse> {
    private final RoleFinder finder;

    public FindRoleQueryHandler(RoleFinder finder) {
        this.finder = finder;
    }

    @Override
    public RoleResponse handle(FindRoleQuery query) {
        RoleId id = new RoleId(query.id());

        return this.finder.find(id);
    }
}
