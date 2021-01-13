package ar.franciscoruiz.accounts.roles.infrastructure;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleDescription;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryRoleRepository implements RoleRepository {
    private final HashMap<String, Role> values;

    public InMemoryRoleRepository() {
        this.values = new HashMap<>() {{
            put("b473929a-92b2-4838-bb08-7887a028bc4c", new Role(
                new RoleId("b473929a-92b2-4838-bb08-7887a028bc4c"),
                new RoleDescription("ADMIN")
            ));
            put("47f9d5b7-5886-476c-a2f6-ea742453f3a4", new Role(
                new RoleId("47f9d5b7-5886-476c-a2f6-ea742453f3a4"),
                new RoleDescription("COMPANY")
            ));
            put("699c38ab-4eb5-447e-8b70-cef2e60ec422", new Role(
                new RoleId("699c38ab-4eb5-447e-8b70-cef2e60ec422"),
                new RoleDescription("EMPLOYEE")
            ));
            put("1764a6e7-cf77-4061-aac0-b589f5810cf5'", new Role(
                new RoleId("1764a6e7-cf77-4061-aac0-b589f5810cf5"),
                new RoleDescription("COACH")
            ));
            put("6e5cbf77-8a3b-45ed-98d2-6f97a08c0ca1", new Role(
                new RoleId("6e5cbf77-8a3b-45ed-98d2-6f97a08c0ca1"),
                new RoleDescription("ATHLETE")
            ));
        }};
    }

    @Override
    public Optional<Role> search(RoleId id) {
        return Optional.ofNullable(this.values.get(id.value()));
    }

    @Override
    public List<Role> all() {
        return new ArrayList<>(this.values.values());
    }
}
