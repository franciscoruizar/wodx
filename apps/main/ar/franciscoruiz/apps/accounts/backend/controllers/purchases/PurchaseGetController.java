package ar.franciscoruiz.apps.accounts.backend.controllers.purchases;

import ar.franciscoruiz.accounts.purchases.application.PurchaseResponse;
import ar.franciscoruiz.accounts.purchases.application.finder.FindPurchaseQuery;
import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemsResponse;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class PurchaseGetController extends ApiController {
    public PurchaseGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/purchases/memberships/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        PurchaseResponse response = ask(new FindPurchaseQuery(id));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", response.id());
            put("description", response.description());
            put("date", response.date());
            put("userId", response.userId());
            put("totalPrice", response.totalPrice());
            put("items", parseItemResponse(response.items()));
        }});
    }

    private List<HashMap<String, Object>> parseItemResponse(PurchaseItemsResponse items) {
        return items.items().stream().map(item -> new HashMap<String, Object>() {{
            put("id", item.id());
            put("purchaseId", item.purchaseId());
            put("quantity", item.quantity());
            put("price", item.price());
            put("membershipId", item.membershipId());
        }}).collect(Collectors.toList());
    }
}


