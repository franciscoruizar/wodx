package ar.franciscoruiz.apps.accounts.backend.controllers.purchases;

import ar.franciscoruiz.accounts.purchases.application.create.CreatePurchaseCommand;
import ar.franciscoruiz.accounts.purchases.domain.items.application.create.CreatePurchaseItemCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.purchases.shared.dto.PurchaseRequest;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public final class PurchasePostController extends ApiController {
    public PurchasePostController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/purchases/memberships")
    public ResponseEntity<String> index(
        @RequestBody PurchaseRequest request
    ) throws CommandHandlerExecutionError {
        dispatch(PurchaseRequest.parseRequest(request));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
