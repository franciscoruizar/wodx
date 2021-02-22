package ar.franciscoruiz.apps.wodx.backend.controllers.sales.memberships;

import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.application.membership.find.FindMembershipQuery;
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
public final class MembershipGetController extends ApiController {
    public MembershipGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/memberships/{id}")
    public ResponseEntity<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        MembershipResponse response = ask(new FindMembershipQuery(id));

        return ResponseEntity.ok().body(response.toPrimitives());
    }
}


