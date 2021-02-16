package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find_by_email.FindUserByEmailQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class UserByEmailGetController extends ApiController {
    public UserByEmailGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users", params = "email")
    public ResponseEntity<HashMap<String, Serializable>> index(@RequestParam String email) throws QueryHandlerExecutionError {
        UserResponse response = ask(new FindUserByEmailQuery(email));

        return ResponseEntity.ok().body(response.toPrimitives());
    }
}
