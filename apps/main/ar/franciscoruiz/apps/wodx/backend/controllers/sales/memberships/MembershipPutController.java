package ar.franciscoruiz.apps.wodx.backend.controllers.sales.memberships;

import ar.franciscoruiz.sales.products.application.membership.create.CreateMembershipCommand;
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
        @RequestBody Request request,
        @PathVariable String id
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreateMembershipCommand(
                id,
                request.title(),
                request.description(),
                request.price(),
                request.isActive(),
                request.companyId(),
                request.numberDaysEnabled()
            )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String  title;
        private String  description;
        private double  price;
        private boolean isActive;
        private String  companyId;
        private Integer numberDaysEnabled;

        public String title() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String description() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double price() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public String companyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public Integer numberDaysEnabled() {
            return numberDaysEnabled;
        }

        public void setNumberDaysEnabled(Integer numberDaysEnabled) {
            this.numberDaysEnabled = numberDaysEnabled;
        }
    }
}
