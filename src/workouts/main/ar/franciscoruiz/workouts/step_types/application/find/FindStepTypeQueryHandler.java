package ar.franciscoruiz.workouts.step_types.application.find;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.workouts.step_types.application.StepTypeResponse;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeNotExist;

@Service
public final class FindStepTypeQueryHandler implements QueryHandler<FindStepTypeQuery, StepTypeResponse> {
    private final StepTypeFinder finder;

    public FindStepTypeQueryHandler(StepTypeFinder finder) {
        this.finder = finder;
    }

    @Override
    public StepTypeResponse handle(FindStepTypeQuery query) throws StepTypeNotExist {
        return finder.find(new StepTypeId(query.id()));
    }
}
