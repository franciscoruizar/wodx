package ar.franciscoruiz.apps.accounts.backend.controllers.purchases;

import ar.franciscoruiz.accounts.purchase_items.application.create.CreatePurchaseItemCommand;
import ar.franciscoruiz.accounts.purchases.application.create.CreatePurchaseCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.purchases.shared.dto.PurchaseRequest;
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
public final class PurchasePutController extends ApiController {
    public PurchasePutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/purchases/{id}")
    public ResponseEntity<String> index(
        @RequestBody PurchaseRequest request,
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

        request.items().forEach(item -> dispatch(new CreatePurchaseItemCommand(item.id(), request.id(), item.quantity(), item.membershipId())));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
