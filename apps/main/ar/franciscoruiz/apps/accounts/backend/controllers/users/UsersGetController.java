package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.UsersResponse;
import ar.franciscoruiz.accounts.users.application.search_by_criteria.SearchUserByCriteriaQuery;
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
public final class UsersGetController extends ApiController {
    public UsersGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users")
    public List<HashMap<String, Object>> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
        UsersResponse response = ask(new SearchUserByCriteriaQuery(
            parseFilters(params),
            Optional.ofNullable((String) params.get("order_by")),
            Optional.ofNullable((String) params.get("order")),
            Optional.ofNullable((Integer) params.get("limit")),
            Optional.ofNullable((Integer) params.get("offset"))
        ));

        return response.values().stream().map(user -> new HashMap<String, Object>() {{
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
