package ar.franciscoruiz.apps.accounts.backend.controllers.users.shared.dto;

public final class UserRequest {
    private String  id;
    private String  name;
    private String  surname;
    private String  email;
    private String password;
    private String  phone;
    private Boolean isActive;
    private String  roleId;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String surname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String email() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String password() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String phone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String roleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
