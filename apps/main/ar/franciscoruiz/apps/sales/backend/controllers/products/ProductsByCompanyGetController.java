package ar.franciscoruiz.apps.sales.backend.controllers.products;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductsResponse;
import ar.franciscoruiz.sales.products.application.material_product.search_by_company.SearchMaterialProductsByCompanyQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class ProductsByCompanyGetController extends ApiController {
    public ProductsByCompanyGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/products/company/{id}")
    public List<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        MaterialProductsResponse response = ask(new SearchMaterialProductsByCompanyQuery(id));

        return response.toPrimitives();
    }
}
