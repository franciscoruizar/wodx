package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies;

import ar.franciscoruiz.accounts.user_companies.application.UserCompaniesResponse;
import ar.franciscoruiz.accounts.user_companies.application.search_by_criteria.SearchUserCompanyByCriteriaQuery;
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
public final class UserCompaniesGetController extends ApiController {
    public UserCompaniesGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/companies")
    public List<HashMap<String, Object>> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
        UserCompaniesResponse response = ask(new SearchUserCompanyByCriteriaQuery(
            parseFilters(params),
            Optional.ofNullable((String) params.get("order_by")),
            Optional.ofNullable((String) params.get("order")),
            Optional.ofNullable((Integer) params.get("limit")),
            Optional.ofNullable((Integer) params.get("offset"))
        ));

        return response.values().stream().map(userCompany -> new HashMap<String, Object>() {{
            put("id", userCompany.id());
            put("user", new HashMap<>() {{
                put("id", userCompany.user().id());
                put("name", userCompany.user().name());
                put("surname", userCompany.user().surname());
                put("email", userCompany.user().email());
                put("phone", userCompany.user().phone());
                put("isActive", userCompany.user().isActive());
                put("roleId", userCompany.user().roleId());
            }});
            put("company", new HashMap<>() {{
                put("id", userCompany.company().id());
                put("description", userCompany.company().description());
                put("mediaUrl", userCompany.company().mediaUrl());
                put("isActive", userCompany.company().isActive());
            }});
        }}).collect(Collectors.toList());
    }
}
