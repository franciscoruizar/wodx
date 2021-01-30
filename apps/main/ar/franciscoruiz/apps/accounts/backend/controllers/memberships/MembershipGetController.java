package ar.franciscoruiz.apps.accounts.backend.controllers.memberships;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.application.find.FindMembershipQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
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
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        MembershipResponse response = ask(new FindMembershipQuery(id));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", response.id());
            put("description", response.description());
            put("numberDaysEnabled", response.numberDaysEnabled());
            put("price", response.price());
            put("companyId", response.companyId());
            put("isActive", response.isActive());
        }});
    }
}
