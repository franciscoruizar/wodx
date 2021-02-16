package ar.franciscoruiz.apps.sales.backend.controllers.memberships;

import ar.franciscoruiz.sales.products.application.membership.MembershipsResponse;
import ar.franciscoruiz.sales.products.application.membership.search_by_company.SearchMembershipsByCompanyQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class MembershipsByCompanyGetController extends ApiController {
    public MembershipsByCompanyGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/memberships/company/{id}")
    public List<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        MembershipsResponse response = ask(new SearchMembershipsByCompanyQuery(id));

        return response.toPrimitives();
    }
}
