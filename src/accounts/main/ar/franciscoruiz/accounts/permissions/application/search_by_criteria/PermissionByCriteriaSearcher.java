package ar.franciscoruiz.accounts.permissions.application.search_by_criteria;

import ar.franciscoruiz.accounts.permissions.application.PermissionResponse;
import ar.franciscoruiz.accounts.permissions.application.PermissionsResponse;
import ar.franciscoruiz.accounts.permissions.domain.PermissionRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class PermissionByCriteriaSearcher {
    private final PermissionRepository repository;

    public PermissionByCriteriaSearcher(PermissionRepository repository) {
        this.repository = repository;
    }

    public PermissionsResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new PermissionsResponse(
            this.repository
                .matching(criteria)
                .stream()
                .map(PermissionResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
