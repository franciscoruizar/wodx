package ar.franciscoruiz.workouts.step_types.domain;

public enum StepTypeLanguage {
    ENGLISH("ENGLISH"),
    SPANISH("SPANISH");

    private final String language;

    StepTypeLanguage(String language) {
        this.language = language;
    }

    public String value() {
        return this.language;
    }
}
