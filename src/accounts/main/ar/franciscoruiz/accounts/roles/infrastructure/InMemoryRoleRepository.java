package ar.franciscoruiz.accounts.roles.infrastructure;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryRoleRepository implements RoleRepository {

    @Override
    public Optional<Role> search(RoleId id) {
        return Optional.of(Role.valueOf(id.value()));
    }

    @Override
    public List<Role> findAll() {
        return Arrays.asList(Role.values().clone());
    }
}
