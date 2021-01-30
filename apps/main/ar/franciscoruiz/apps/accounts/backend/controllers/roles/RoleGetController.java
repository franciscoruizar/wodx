package ar.franciscoruiz.apps.accounts.backend.controllers.roles;

import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.application.find.FindRoleQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class RoleGetController extends ApiController {
    public RoleGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/roles/{id}")
    public HashMap<String, Object> index(@RequestParam String id) throws QueryHandlerExecutionError {
        RoleResponse response = ask(new FindRoleQuery(id));

        return new HashMap<>() {{
            put("id", response.id());
            put("description", response.description());
        }};
    }
}
