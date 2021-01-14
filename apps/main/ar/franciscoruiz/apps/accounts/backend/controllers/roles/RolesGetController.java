package ar.franciscoruiz.apps.accounts.backend.controllers.roles;

import ar.franciscoruiz.accounts.permissions.application.PermissionsResponse;
import ar.franciscoruiz.accounts.roles.application.RolesResponse;
import ar.franciscoruiz.accounts.roles.application.search_all.SearchAllRolesQuery;
import ar.franciscoruiz.accounts.roles.domain.RoleNotExist;
import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class RolesGetController extends ApiController {
    public RolesGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<HashMap<String, Object>>> index() throws QueryHandlerExecutionError {
        RolesResponse response = ask(new SearchAllRolesQuery());

        return ResponseEntity.ok().body(
            response.values().stream().map(role -> new HashMap<String, Object>() {{
                put("id", role.id());
                put("description", role.description());
                put("permissions", parsePermissions(role.permissions()));
            }}).collect(Collectors.toList())
        );
    }


    private List<HashMap<String, Serializable>> parsePermissions(PermissionsResponse permissions) {
        return permissions.values().stream().map(permission -> new HashMap<String, Serializable>() {{
            put("id", permission.id());
            put("entity", permission.entity());
            put("create", permission.create());
            put("update", permission.update());
            put("delete", permission.delete());
            put("read", permission.read());
            put("readAll", permission.readAll());
        }}).collect(Collectors.toList());
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>() {{
            put(RoleNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
