package ar.franciscoruiz.apps.accounts.backend.controllers.companies;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.accounts.companies.application.find.FindCompanyQuery;
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
public final class CompanyGetController extends ApiController {
    public CompanyGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/companies/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        CompanyResponse response = ask(new FindCompanyQuery(id));

        return ResponseEntity.ok().body(new HashMap<String, Serializable>() {{
            put("id", response.id());
            put("description", response.description());
            put("mediaUrl", response.mediaUrl());
            put("latitude", response.latitude());
            put("longitude", response.longitude());
            put("isActive", response.isActive());
        }});
    }
}
