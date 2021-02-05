package ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.application.find.FindMembershipQuery;
import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.accounts.user_memberships.application.search_by_user.SearchUserMembershipByUserQuery;
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
import java.util.stream.Collectors;

@RestController
public final class UserMembershipsByUserGetController extends ApiController {
    public UserMembershipsByUserGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/memberships", params = "userId")
    public List<HashMap<String, Serializable>> index(@RequestParam String userId) throws QueryHandlerExecutionError {
        UserMembershipsResponse response = ask(new SearchUserMembershipByUserQuery(userId));

        return response.values().stream().map(userMembership -> {
            MembershipResponse membership = ask(new FindMembershipQuery(userMembership.membershipId()));

            return new HashMap<String, Serializable>() {{
                put("id", userMembership.id());
                put("dateFrom", userMembership.dateFrom());
                put("dateTo", userMembership.dateTo());
                put("membership", new HashMap<>() {{
                    put("id", membership.id());
                    put("description", membership.description());
                    put("numberDaysEnabled", membership.numberDaysEnabled());
                    put("price", membership.price());
                    put("companyId", membership.companyId());
                }});
            }};
        }).collect(Collectors.toList());
    }
}
