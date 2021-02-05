package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies;

import ar.franciscoruiz.accounts.user_companies.application.search_by_user.CompaniesByUserResponse;
import ar.franciscoruiz.accounts.user_companies.application.search_by_user.SearchCompaniesByUserQuery;
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
public final class CompaniesByUserGetController extends ApiController {
    public CompaniesByUserGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/companies", params = "userId")
    public List<HashMap<String, Object>> index(@RequestParam String userId) throws QueryHandlerExecutionError {
        CompaniesByUserResponse response = ask(new SearchCompaniesByUserQuery(userId));

        return response.companies().stream().map(company -> new HashMap<String, Object>() {{
            put("id", company.id());
            put("description", company.description());
            put("mediaUrl", company.mediaUrl());
            put("latitude", company.latitude());
            put("longitude", company.longitude());
            put("isActive", company.isActive());
        }}).collect(Collectors.toList());
    }
}
