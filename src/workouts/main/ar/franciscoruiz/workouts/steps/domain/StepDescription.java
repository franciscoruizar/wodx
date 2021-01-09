package ar.franciscoruiz.workouts.steps.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class StepDescription extends StringValueObject {
    public StepDescription(String value) {
        super(value);
    }

    private StepDescription() {
        super(null);
    }
}
