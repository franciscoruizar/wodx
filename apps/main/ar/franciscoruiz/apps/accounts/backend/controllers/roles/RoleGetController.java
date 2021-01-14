package ar.franciscoruiz.apps.accounts.backend.controllers.roles;

import ar.franciscoruiz.accounts.permissions.application.PermissionsResponse;
import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.application.find.FindRoleQuery;
import ar.franciscoruiz.accounts.roles.domain.RoleNotExist;
import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class RoleGetController extends ApiController {
    public RoleGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/roles/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        RoleResponse response = ask(new FindRoleQuery(id));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", response.id());
            put("description", response.description());
            put("permissions", parsePermissions(response.permissions()));
        }});
    }

    private List<HashMap<String, Serializable>> parsePermissions(PermissionsResponse permissions) {
        return permissions.values().stream().map((permission -> new HashMap<String, Serializable>() {{
            put("id", permission.id());
            put("entity", permission.entity());
            put("create", permission.create());
            put("update", permission.update());
            put("delete", permission.delete());
            put("read", permission.read());
            put("readAll", permission.readAll());
        }})).collect(Collectors.toList());
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>() {{
            put(RoleNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
