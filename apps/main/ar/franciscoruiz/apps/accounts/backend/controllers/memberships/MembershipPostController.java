package ar.franciscoruiz.apps.accounts.backend.controllers.memberships;

import ar.franciscoruiz.accounts.memberships.application.create.CreateMembershipCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.memberships.dto.MembershipRequest;
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
public final class MembershipPostController extends ApiController {
    public MembershipPostController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/memberships")
    public ResponseEntity<String> index(
        @RequestBody MembershipRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateMembershipCommand(
                request.id(),
                request.description(),
                request.numberDaysEnabled(),
                request.price(),
                request.companyId(),
                request.isActive()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
