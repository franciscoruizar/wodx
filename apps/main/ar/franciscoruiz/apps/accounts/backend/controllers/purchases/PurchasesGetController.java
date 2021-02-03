package ar.franciscoruiz.apps.accounts.backend.controllers.purchases;

import ar.franciscoruiz.accounts.purchases.application.PurchasesResponse;
import ar.franciscoruiz.accounts.purchases.application.search_by_company.SearchPurchaseByCompanyQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping(value = "/purchases/company/{id}")
    public List<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        PurchasesResponse response = ask(new SearchPurchaseByCompanyQuery(id));

        return response.values().stream().map(purchase -> new HashMap<String, Object>() {{
            put("id", purchase.id());
            put("description", purchase.description());
            put("date", purchase.date());
            put("userId", purchase.userId());
            put("totalPrice", purchase.totalPrice());
        }}).collect(Collectors.toList());
    }
}
