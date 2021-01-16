package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies;

import ar.franciscoruiz.accounts.user_companies.application.create.CreateUserCompanyCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.user_companies.shared.dto.UserCompanyRequest;
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
public final class UserCompanyPostController extends ApiController {
    public UserCompanyPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/users/companies")
    public ResponseEntity<String> index(
        @RequestBody UserCompanyRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateUserCompanyCommand(
                request.id(),
                request.userId(),
                request.companyId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
