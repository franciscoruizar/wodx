package ar.franciscoruiz.accounts.roles.application.find;

import ar.franciscoruiz.accounts.permissions.domain.PermissionNotExist;
import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleNotExist;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class RoleFinder {
    private final RoleRepository repository;

    public RoleFinder(RoleRepository repository) {
        this.repository = repository;
    }

    public RoleResponse find(RoleId id){
        return this.repository
            .search(id)
            .map(RoleResponse::fromAggregate)
            .orElseThrow(() -> new RoleNotExist(id));
    }
}
