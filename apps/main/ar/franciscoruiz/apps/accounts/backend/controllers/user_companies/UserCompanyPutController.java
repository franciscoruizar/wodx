package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies;

import ar.franciscoruiz.accounts.user_companies.application.create.CreateUserCompanyCommand;
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
public final class UserCompanyPutController extends ApiController {
    public UserCompanyPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/users/companies/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
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

    static class Request {
        private String userId;
        private String companyId;

        public String userId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String companyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }
    }
}
