package ar.franciscoruiz.workouts.step_types.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.step_types.application.StepTypeResponse;
import ar.franciscoruiz.workouts.step_types.application.StepTypesResponse;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class StepTypesByCriteriaSearcher {
    private final StepTypeRepository repository;

    public StepTypesByCriteriaSearcher(StepTypeRepository repository) {
        this.repository = repository;
    }

    public StepTypesResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new StepTypesResponse(
            repository.matching(criteria)
                .stream()
                .map(StepTypeResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
