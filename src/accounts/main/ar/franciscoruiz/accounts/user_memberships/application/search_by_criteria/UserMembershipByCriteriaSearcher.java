package ar.franciscoruiz.accounts.user_memberships.application.search_by_criteria;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipResponse;
import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class UserMembershipByCriteriaSearcher {
    private final UserMembershipRepository repository;

    public UserMembershipByCriteriaSearcher(UserMembershipRepository repository) {
        this.repository = repository;
    }

    public UserMembershipsResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new UserMembershipsResponse(
            this.repository
                .matching(criteria)
                .stream()
                .map(UserMembershipResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
