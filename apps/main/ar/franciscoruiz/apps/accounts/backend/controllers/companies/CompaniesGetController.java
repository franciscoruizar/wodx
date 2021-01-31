package ar.franciscoruiz.apps.accounts.backend.controllers.companies;

import ar.franciscoruiz.accounts.companies.application.CompaniesResponse;
import ar.franciscoruiz.accounts.companies.application.search_all.SearchAllCompaniesQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class CompaniesGetController extends ApiController {
    public CompaniesGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/companies")
    public List<HashMap<String, Object>> index() throws QueryHandlerExecutionError {
        CompaniesResponse response = ask(new SearchAllCompaniesQuery());

        return response.values().stream().map(company -> new HashMap<String, Object>() {{
            put("id", company.id());
            put("description", company.description());
            put("mediaUrl", company.mediaUrl());
            put("latitude", company.latitude());
            put("longitude", company.longitude());
            put("isActive", company.isActive());
        }}).collect(Collectors.toList());
    }
}
