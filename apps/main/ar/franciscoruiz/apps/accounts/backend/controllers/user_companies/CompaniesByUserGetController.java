package ar.franciscoruiz.apps.accounts.backend.controllers.user_companies;

import ar.franciscoruiz.accounts.user_companies.application.search_by_user.CompaniesByUserResponse;
import ar.franciscoruiz.accounts.user_companies.application.search_by_user.SearchCompaniesByUserQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@RestController
public final class CompaniesByUserGetController extends ApiController {
    public CompaniesByUserGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/companies", params = "userId")
    public List<HashMap<String, Serializable>> index(@RequestParam String userId) throws QueryHandlerExecutionError {
        CompaniesByUserResponse response = ask(new SearchCompaniesByUserQuery(userId));

        return response.toPrimitives();
    }
}
