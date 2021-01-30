package ar.franciscoruiz.apps.accounts.backend.controllers.purchases;

import ar.franciscoruiz.accounts.purchases.application.PurchasesResponse;
import ar.franciscoruiz.accounts.purchases.application.search_by_criteria.SearchPurchaseByCriteriaQuery;
import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemsResponse;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class PurchasesGetController extends ApiController {
    public PurchasesGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/purchases/memberships")
    public List<HashMap<String, Object>> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
        PurchasesResponse response = ask(new SearchPurchaseByCriteriaQuery(
            parseFilters(params),
            Optional.ofNullable((String) params.get("order_by")),
            Optional.ofNullable((String) params.get("order")),
            Optional.ofNullable((Integer) params.get("limit")),
            Optional.ofNullable((Integer) params.get("offset"))
        ));

        return response.values().stream().map(purchase -> new HashMap<String, Object>() {{
            put("id", purchase.id());
            put("description", purchase.description());
            put("date", purchase.date());
            put("userId", purchase.userId());
            put("totalPrice", purchase.totalPrice());
            put("items", parseItemResponse(purchase.items()));
        }}).collect(Collectors.toList());
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
