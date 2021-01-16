package ar.franciscoruiz.apps.accounts.backend.controllers.companies;

import ar.franciscoruiz.accounts.companies.application.create.CreateCompanyCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.companies.shared.dto.CompanyRequest;
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
public final class CompanyPutController extends ApiController {
    public CompanyPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/companies/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody CompanyRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateCompanyCommand(
                id,
                request.description(),
                request.mediaUrl(),
                request.latitude(),
                request.longitude(),
                request.isActive()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
