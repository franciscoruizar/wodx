package ar.franciscoruiz.workouts.step_exercises.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateStepExerciseCommand implements Command {
    private final String  id;
    private final Integer series;
    private final Integer value;
    private final String  timeUnit;
    private final String  stepId;
    private final String  exerciseId;

    public CreateStepExerciseCommand(String id, Integer series, Integer value, String timeUnit, String stepId, String exerciseId) {
        this.id         = id;
        this.series     = series;
        this.value      = value;
        this.timeUnit   = timeUnit;
        this.stepId     = stepId;
        this.exerciseId = exerciseId;
    }

    public String id() {
        return this.id;
    }

    public Integer series() {
        return this.series;
    }

    public Integer value() {
        return this.value;
    }

    public String timeUnit() {
        return this.timeUnit;
    }

    public String stepId() {
        return this.stepId;
    }

    public String exerciseId() {
        return this.exerciseId;
    }
}
