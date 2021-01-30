package ar.franciscoruiz.accounts.memberships.application.search_by_criteria;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.application.MembershipsResponse;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class MembershipByCriteriaSearcher {
    private final MembershipRepository repository;

    public MembershipByCriteriaSearcher(MembershipRepository repository) {
        this.repository = repository;
    }

    public MembershipsResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new MembershipsResponse(
            this.repository
                .matching(criteria)
                .stream()
                .map(MembershipResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
