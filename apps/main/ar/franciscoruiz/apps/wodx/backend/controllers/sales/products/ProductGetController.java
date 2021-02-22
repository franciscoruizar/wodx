package ar.franciscoruiz.apps.wodx.backend.controllers.sales.products;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductResponse;
import ar.franciscoruiz.sales.products.application.material_product.find.FindMaterialProductQuery;
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
public final class ProductGetController extends ApiController {
    public ProductGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        MaterialProductResponse response = ask(new FindMaterialProductQuery(id));

        return ResponseEntity.ok().body(response.toPrimitives());
    }
}


