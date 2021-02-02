package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find.FindUserQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class UserGetController extends ApiController {
    public UserGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        UserResponse response = ask(new FindUserQuery(id));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", response.id());
            put("name", response.name());
            put("surname", response.surname());
            put("email", response.email());
            put("phone", response.phone());
            put("isActive", response.isActive());
            put("roleId", response.roleId());
        }});
    }
}
