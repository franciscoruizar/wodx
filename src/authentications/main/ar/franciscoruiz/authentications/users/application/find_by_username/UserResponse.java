package ar.franciscoruiz.authentications.users.application.find_by_username;

import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class UserResponse implements Response {
    private final String  id;
    private final String  name;
    private final String  surname;
    private final String  email;
    private final String  phone;
    private final Boolean isActive;
    private final String  role;

    public UserResponse(String id, String name, String surname, String email, String phone, Boolean isActive, String role) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.email    = email;
        this.phone    = phone;
        this.isActive = isActive;
        this.role   = role;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public Boolean isActive() {
        return isActive;
    }

    public String role() {
        return role;
    }
}
