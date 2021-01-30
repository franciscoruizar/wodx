package ar.franciscoruiz.accounts.roles.application.search_all;

import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.application.RolesResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;

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
                .map(RoleResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
