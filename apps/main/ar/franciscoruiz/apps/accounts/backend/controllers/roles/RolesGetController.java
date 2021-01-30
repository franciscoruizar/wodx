package ar.franciscoruiz.apps.accounts.backend.controllers.roles;

import ar.franciscoruiz.accounts.roles.application.RolesResponse;
import ar.franciscoruiz.accounts.roles.application.search_all.SearchAllRolesQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class RolesGetController extends ApiController {
    public RolesGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/roles")
    public List<HashMap<String, Object>> index() throws QueryHandlerExecutionError {
        RolesResponse response = ask(new SearchAllRolesQuery());

        return response.values().stream().map(role -> new HashMap<String, Object>() {{
            put("id", role.id());
            put("description", role.description());
        }}).collect(Collectors.toList());
    }
}
