package ar.franciscoruiz.apps.accounts.backend.controllers.auth;

import ar.franciscoruiz.accounts.auth.application.authenticate.AuthenticateUserCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class AuthenticationPostController extends ApiController {
    public AuthenticationPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<String> index(
        @RequestBody AuthRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(new AuthenticateUserCommand(request.username(), request.password()));

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

class AuthRequest {
    private String username;
    private String password;

    public String username() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String password() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
