package ar.franciscoruiz.apps.accounts.backend.controllers.purchases;

import ar.franciscoruiz.apps.accounts.backend.controllers.purchases.shared.dto.PurchaseRequest;
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

@RestController
public final class PurchasePutController extends ApiController {
    public PurchasePutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/purchases/memberships/{id}")
    public ResponseEntity<String> index(
        @RequestBody PurchaseRequest request,
        @RequestParam String id
    ) throws CommandHandlerExecutionError, Exception {
        if (!id.equals(request.id())) {
            throw new Exception("request param id not equals to request body id");
        }

        dispatch(PurchaseRequest.parseRequest(request));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
