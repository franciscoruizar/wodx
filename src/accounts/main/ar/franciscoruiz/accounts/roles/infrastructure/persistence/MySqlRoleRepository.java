package ar.franciscoruiz.accounts.roles.infrastructure.persistence;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlRoleRepository extends HibernateRepository<Role> implements RoleRepository {
    public MySqlRoleRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, Role.class, "accounts");
    }

    @Override
    public Optional<Role> search(RoleId id) {
        return byId(id);
    }

    @Override
    public List<Role> findAll() {
        return all();
    }
}
