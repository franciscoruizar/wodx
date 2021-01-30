package ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships;

import ar.franciscoruiz.accounts.user_memberships.application.create.CreateUserMembershipCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships.dto.UserMembershipRequest;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserMembershipPutController extends ApiController {
    public UserMembershipPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/users/memberships/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody UserMembershipRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateUserMembershipCommand(
                id,
                request.dateFrom(),
                request.membershipId(),
                request.userId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
