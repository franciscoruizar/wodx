package ar.franciscoruiz.apps.accounts.backend.controllers.memberships;

import ar.franciscoruiz.accounts.memberships.application.MembershipsResponse;
import ar.franciscoruiz.accounts.memberships.application.search_by_company.SearchMembershipByCompany;
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
public final class MembershipsByCompanyGetController extends ApiController {
    public MembershipsByCompanyGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/memberships/company/{id}")
    public List<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        MembershipsResponse response = ask(new SearchMembershipByCompany(id));

        return response.values().stream().map(membership -> new HashMap<String, Object>() {{
            put("id", membership.id());
            put("description", membership.description());
            put("numberDaysEnabled", membership.numberDaysEnabled());
            put("price", membership.price());
            put("companyId", membership.companyId());
            put("isActive", membership.isActive());
        }}).collect(Collectors.toList());
    }
}
