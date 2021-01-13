package ar.franciscoruiz.accounts.roles.domain;

public enum Role {
    ADMIN("b473929a-92b2-4838-bb08-7887a028bc4c"),
    COMPANY("47f9d5b7-5886-476c-a2f6-ea742453f3a4"),
    EMPLOYEE("699c38ab-4eb5-447e-8b70-cef2e60ec422"),
    COACH("1764a6e7-cf77-4061-aac0-b589f5810cf5'"),
    ATHLETE("6e5cbf77-8a3b-45ed-98d2-6f97a08c0ca1");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
