package ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.accounts.user_memberships.application.search_by_membership.SearchUserMembershipByMembershipQuery;
import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find.FindUserQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class UserMembershipsByMembershipGetController extends ApiController {
    public UserMembershipsByMembershipGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/memberships", params = "membershipId")
    public List<HashMap<String, Serializable>> index(@RequestParam String membershipId) throws QueryHandlerExecutionError {
        UserMembershipsResponse response = ask(new SearchUserMembershipByMembershipQuery(membershipId));

        return response.values().stream().map(userMembership -> {
            UserResponse user = ask(new FindUserQuery(userMembership.userId()));

            return new HashMap<String, Serializable>() {{
                put("id", userMembership.id());
                put("dateFrom", userMembership.dateFrom());
                put("dateTo", userMembership.dateTo());
                put("user", new HashMap<>() {{
                    put("id", userMembership.userId());
                    put("name", user.name());
                    put("surname", user.surname());
                    put("email", user.email());
                    put("phone", user.phone());
                }});
            }};
        }).collect(Collectors.toList());
    }
}
