package ar.franciscoruiz.accounts.users.application;

import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;

public final class UserResponse implements Response {
    private final String  id;
    private final String  name;
    private final String  surname;
    private final String  email;
    private final String  phone;
    private final Boolean isActive;
    private final String  roleId;

    public UserResponse(String id, String name, String surname, String email, String phone, Boolean isActive, String roleId) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.email    = email;
        this.phone    = phone;
        this.isActive = isActive;
        this.roleId   = roleId;
    }

    public static UserResponse fromAggregate(User entity) {
        return new UserResponse(
            entity.id(),
            entity.name(),
            entity.surname(),
            entity.email(),
            entity.phone(),
            entity.isActive(),
            entity.roleId()
        );
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String surname() {
        return this.surname;
    }

    public String email() {
        return this.email;
    }

    public String phone() {
        return this.phone;
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public String roleId() {
        return this.roleId;
    }

    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> response = new HashMap<>();

        response.put("id", this.id);
        response.put("name", this.name);
        response.put("surname", this.surname);
        response.put("email", this.email);
        response.put("phone", this.phone);
        response.put("is_active", this.isActive);
        response.put("role_id", this.roleId);

        return response;
    }
}
