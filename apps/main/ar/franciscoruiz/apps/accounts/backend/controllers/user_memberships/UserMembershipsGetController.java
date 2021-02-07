package ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.accounts.user_memberships.application.find.FindUserMembershipQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class UserMembershipsGetController extends ApiController {
    public UserMembershipsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/memberships/{id}")
    public List<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        UserMembershipsResponse response = ask(new FindUserMembershipQuery(id));

        return response.toPrimitives();
    }
}
