package ar.franciscoruiz.apps.accounts.backend.controllers.memberships;

import ar.franciscoruiz.accounts.memberships.application.MembershipsResponse;
import ar.franciscoruiz.accounts.memberships.application.search_by_company.SearchMembershipByCompany;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
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
    public List<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        MembershipsResponse response = ask(new SearchMembershipByCompany(id));

        return response.toPrimitives();
    }
}
