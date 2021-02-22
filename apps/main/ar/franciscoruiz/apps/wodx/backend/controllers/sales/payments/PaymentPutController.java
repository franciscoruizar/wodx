package ar.franciscoruiz.apps.wodx.backend.controllers.sales.payments;

import ar.franciscoruiz.sales.payments.application.create.CreatePaymentCommand;
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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public final class PaymentPutController extends ApiController {
    public PaymentPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/payments/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> index(
        @RequestBody Request request,
        @RequestParam String id
    ) throws CommandHandlerExecutionError {
        dispatch(
            new CreatePaymentCommand(
                id,
                request.method(),
                request.mount(),
                request.purchaseId(),
                request.date()
            )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String        method;
        private Double        mount;
        private String        purchaseId;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime date;

        public String method() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public Double mount() {
            return mount;
        }

        public void setMount(Double mount) {
            this.mount = mount;
        }

        public String purchaseId() {
            return purchaseId;
        }

        public void setPurchaseId(String purchaseId) {
            this.purchaseId = purchaseId;
        }

        public LocalDateTime date() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }
    }
}
