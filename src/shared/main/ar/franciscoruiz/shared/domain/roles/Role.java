package ar.franciscoruiz.shared.domain.roles;

public enum Role {
    ADMIN("f7030ab4-d20f-469b-8ee4-a1c5e27bee36"),
    COMPANY("870c1fe5-af03-43f1-a0b3-1988058ed405"),
    EMPLOYEE("ccdc5863-1061-4b9c-9061-4af9a6c60357"),
    USER("3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public RoleId value() {
        return new RoleId(value);
    }
}
