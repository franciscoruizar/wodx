package ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships;

import ar.franciscoruiz.accounts.user_memberships.application.create.CreateUserMembershipCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships.dto.UserMembershipRequest;
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
public final class UserMembershipPostController extends ApiController {
    public UserMembershipPostController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/users/memberships")
    public ResponseEntity<String> index(
        @RequestBody UserMembershipRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateUserMembershipCommand(
                request.id(),
                request.dateFrom(),
                request.membershipId(),
                request.userId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
