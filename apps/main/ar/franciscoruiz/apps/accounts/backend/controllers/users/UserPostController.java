package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.create.CreateUserCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.users.shared.dto.UserRequest;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public final class UserPostController extends ApiController {
    public UserPostController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<String> index(
        @RequestBody UserRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateUserCommand(
                request.id(),
                request.name(),
                request.surname(),
                request.email(),
                request.password(),
                request.phone(),
                request.isActive(),
                request.roleId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
