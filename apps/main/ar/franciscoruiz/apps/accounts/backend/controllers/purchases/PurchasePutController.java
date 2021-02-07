package ar.franciscoruiz.apps.accounts.backend.controllers.purchases;

import ar.franciscoruiz.accounts.items.application.create.CreateItemCommand;
import ar.franciscoruiz.accounts.purchases.application.create.CreatePurchaseCommand;
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

import java.time.LocalDateTime;
import java.util.List;

@RestController
public final class PurchasePutController extends ApiController {
    public PurchasePutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/purchases/{id}")
    public ResponseEntity<String> index(
        @RequestBody Request request,
        @PathVariable String id
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreatePurchaseCommand(
                id,
                request.description(),
                request.date(),
                request.userId(),
                request.companyId()
            )
        );

        request.items().forEach(item -> dispatch(new CreateItemCommand(item.id(), id, item.quantity(), item.membershipId())));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    static class Request {
        private String            description;
        private LocalDateTime     date;
        private String            userId;
        private String            companyId;
        private List<ItemRequest> items;

        public String description() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LocalDateTime date() {
            return this.date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public String userId() {
            return this.userId;
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

        public List<ItemRequest> items() {
            return this.items;
        }

        public void setItems(List<ItemRequest> items) {
            this.items = items;
        }
    }

    static class ItemRequest {
        private String  id;
        private Integer quantity;
        private String  membershipId;

        public String id() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer quantity() {
            return this.quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String membershipId() {
            return this.membershipId;
        }

        public void setMembershipId(String membershipId) {
            this.membershipId = membershipId;
        }
    }
}
