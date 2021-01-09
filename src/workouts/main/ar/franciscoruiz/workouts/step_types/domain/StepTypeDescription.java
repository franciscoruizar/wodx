package ar.franciscoruiz.workouts.step_types.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class StepTypeDescription extends StringValueObject {
    public StepTypeDescription(String value) {
        super(value);
    }

    private StepTypeDescription() {
        super(null);
    }
}
