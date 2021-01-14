package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies;

import ar.franciscoruiz.accounts.user_companies.application.create.CreateUserCompanyCommand;
import ar.franciscoruiz.apps.accounts.shared.dto.user_companies.UserCompanyRequest;
import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class UserCompanyPutController extends ApiController {
    public UserCompanyPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/users/companies/{id}")
    public ResponseEntity<String> index(
        @RequestParam String id,
        @RequestBody UserCompanyRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateUserCompanyCommand(
                id,
                request.userId(),
                request.companyId()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
