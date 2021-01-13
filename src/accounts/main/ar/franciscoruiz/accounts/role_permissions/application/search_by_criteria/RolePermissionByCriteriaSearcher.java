package ar.franciscoruiz.accounts.role_permissions.application.search_by_criteria;

import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionResponse;
import ar.franciscoruiz.accounts.role_permissions.application.RolePermissionsResponse;
import ar.franciscoruiz.accounts.role_permissions.domain.RolePermissionRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class RolePermissionByCriteriaSearcher {
    private final RolePermissionRepository repository;

    public RolePermissionByCriteriaSearcher(RolePermissionRepository repository) {
        this.repository = repository;
    }

    public RolePermissionsResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new RolePermissionsResponse(
            this.repository
                .matching(criteria)
                .stream()
                .map(RolePermissionResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
