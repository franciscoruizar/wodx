package ar.franciscoruiz.workouts.steps.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.workouts.steps.application.StepResponse;
import ar.franciscoruiz.workouts.steps.domain.StepId;
import ar.franciscoruiz.workouts.steps.domain.StepNotExist;

@Service
public final class FindStepQueryHandler implements QueryHandler<FindStepQuery, StepResponse> {
    private final StepFinder finder;

    public FindStepQueryHandler(StepFinder finder) {
        this.finder = finder;
    }

    @Override
    public StepResponse handle(FindStepQuery query) throws StepNotExist {
        return finder.find(new StepId(query.id()));
    }
}
