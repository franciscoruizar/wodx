package ar.franciscoruiz.accounts.roles.application.find;

import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleNotExist;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.roles.RoleId;

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

        return RoleResponse.fromAggregate(role);
    }

}
