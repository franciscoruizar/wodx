package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies;

import ar.franciscoruiz.accounts.user_companies.application.search_by_company.SearchUsersByCompanyQuery;
import ar.franciscoruiz.accounts.user_companies.application.search_by_company.UsersByCompanyResponse;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class UsersByCompanyGetController extends ApiController {
    public UsersByCompanyGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/companies", params = "companyId")
    public List<HashMap<String, Object>> index(@RequestParam String companyId) throws QueryHandlerExecutionError {
        UsersByCompanyResponse response = ask(new SearchUsersByCompanyQuery(companyId));

        return response.users().stream().map(user -> new HashMap<String, Object>() {{
            put("id", user.id());
            put("name", user.name());
            put("surname", user.surname());
            put("email", user.email());
            put("phone", user.phone());
            put("isActive", user.isActive());
            put("roleId", user.roleId());
        }}).collect(Collectors.toList());
    }
}
