package ar.franciscoruiz.apps.accounts.backend.controllers.memberships;

import ar.franciscoruiz.accounts.memberships.application.create.CreateMembershipCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class MembershipPutController extends ApiController {
    public MembershipPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/memberships/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateMembershipCommand(
                id,
                request.description(),
                request.numberDaysEnabled(),
                request.price(),
                request.companyId(),
                request.isActive()
            )
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String  description;
        private Integer numberDaysEnabled;
        private Double  price;
        private String  companyId;
        private boolean isActive;

        public String description() {
            return this.description;
        }

        public Integer numberDaysEnabled() {
            return this.numberDaysEnabled;
        }

        public Double price() {
            return this.price;
        }

        public String companyId() {
            return this.companyId;
        }

        public boolean isActive() {
            return this.isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setNumberDaysEnabled(Integer numberDaysEnabled) {
            this.numberDaysEnabled = numberDaysEnabled;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }
    }
}
