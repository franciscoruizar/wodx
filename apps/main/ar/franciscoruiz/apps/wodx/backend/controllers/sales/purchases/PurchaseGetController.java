package ar.franciscoruiz.apps.wodx.backend.controllers.sales.purchases;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.application.find.FindPurchaseQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class PurchaseGetController extends ApiController {
    public PurchaseGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/purchases/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        PurchaseResponse response = ask(new FindPurchaseQuery(id));

        return ResponseEntity.ok().body(response.toPrimitives());
    }
}


