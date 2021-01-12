package ar.franciscoruiz.workouts.steps.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import ar.franciscoruiz.workouts.steps.application.StepResponse;
import ar.franciscoruiz.workouts.steps.application.StepsResponse;
import ar.franciscoruiz.workouts.steps.domain.StepRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class StepsByCriteriaSearcher {
    private final StepRepository repository;

    public StepsByCriteriaSearcher(StepRepository repository) {
        this.repository = repository;
    }

    public StepsResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new StepsResponse(
            repository.matching(criteria).stream()
                .map(StepResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
