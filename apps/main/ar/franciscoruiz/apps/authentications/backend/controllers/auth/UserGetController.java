package ar.franciscoruiz.apps.authentications.backend.controllers.auth;

import ar.franciscoruiz.authentications.users.application.find_by_username.FindUserByEmailQuery;
import ar.franciscoruiz.authentications.users.application.find_by_username.UserResponse;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/users", params = "email")
    public ResponseEntity<HashMap<String, Object>> index(@RequestParam String email) throws QueryHandlerExecutionError {
        UserResponse response = ask(new FindUserByEmailQuery(email));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", response.id());
            put("name", response.name());
            put("surname", response.surname());
            put("email", response.email());
            put("phone", response.phone());
            put("isActive", response.isActive());
            put("role", response.role());
        }});
    }
}
