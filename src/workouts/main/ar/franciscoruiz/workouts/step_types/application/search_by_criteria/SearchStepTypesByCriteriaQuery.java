package ar.franciscoruiz.workouts.step_types.application.search_by_criteria;

import ar.franciscoruiz.shared.domain.bus.query.ByCriteriaQuery;
import ar.franciscoruiz.shared.domain.bus.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class SearchStepTypesByCriteriaQuery extends ByCriteriaQuery implements Query {
    public SearchStepTypesByCriteriaQuery(
        List<HashMap<String, String>> filters,
        Optional<String> orderBy,
        Optional<String> orderType,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        super(filters, orderBy, orderType, limit, offset);
    }
}
