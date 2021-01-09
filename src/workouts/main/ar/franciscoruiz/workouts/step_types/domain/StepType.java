package ar.franciscoruiz.workouts.step_types.domain;

import java.util.Objects;

public final class StepType {
    private final StepTypeId          id;
    private final StepTypeDescription description;
    private final StepTypeLanguage    language;

    public StepType(StepTypeId id, StepTypeDescription description, StepTypeLanguage language) {
        this.id          = id;
        this.description = description;
        this.language    = language;
    }

    public StepType() {
        this.id          = null;
        this.description = null;
        this.language    = null;
    }

    public StepTypeId id() {
        return this.id;
    }

    public StepTypeDescription description() {
        return this.description;
    }

    public StepTypeLanguage language() {
        return this.language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepType stepType = (StepType) o;
        return Objects.equals(id, stepType.id) && Objects.equals(description, stepType.description) && Objects.equals(language, stepType.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, language);
    }
}
