package ar.franciscoruiz.accounts.permissions.application.find;

import ar.franciscoruiz.accounts.permissions.application.PermissionResponse;
import ar.franciscoruiz.accounts.permissions.domain.PermissionId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindPermissionQueryHandler implements QueryHandler<FindPermissionQuery, PermissionResponse> {
    private final PermissionFinder finder;

    public FindPermissionQueryHandler(PermissionFinder finder) {
        this.finder = finder;
    }

    @Override
    public PermissionResponse handle(FindPermissionQuery query) {
        PermissionId id = new PermissionId(query.id());

        return this.finder.find(id);
    }
}
