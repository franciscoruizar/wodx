package ar.franciscoruiz.apps.sales.backend.controllers.purchases;

import ar.franciscoruiz.sales.purchases.application.create.CreateItemCommand;
import ar.franciscoruiz.sales.purchases.application.create.CreatePurchaseCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class PurchasePutController extends ApiController {
    public PurchasePutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/purchases/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
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
                request.companyId(),
                request.items().stream().map(itemRequest -> new CreateItemCommand(
                    itemRequest.id(),
                    itemRequest.quantity(),
                    itemRequest.productId()
                )).collect(Collectors.toList())
            )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String            description;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime     date;
        private String            userId;
        private String            companyId;
        private List<ItemRequest> items;

        public String description() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LocalDateTime date() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

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

        public List<ItemRequest> items() {
            return items;
        }

        public void setItems(List<ItemRequest> items) {
            this.items = items;
        }
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class ItemRequest {
        private String id;
        private int    quantity;
        private String productId;

        public String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer quantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String productId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }
    }
}
