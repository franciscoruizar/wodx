package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.roles.RoleId;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Optional<Role> search(RoleId id);

    List<Role> findAll();
}
