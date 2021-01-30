package ar.franciscoruiz.accounts.users.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateUserCommand implements Command {
    private final String  id;
    private final String  name;
    private final String  surname;
    private final String  email;
    private final String password;
    private final String  phone;
    private final Boolean isActive;
    private final String  roleId;

    public CreateUserCommand(
        String id,
        String name,
        String surname,
        String email,
        String password,
        String phone,
        Boolean isActive,
        String roleId
    ) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.email    = email;
        this.password = password;
        this.phone    = phone;
        this.isActive = isActive;
        this.roleId   = roleId;
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

    public String password() {
        return this.password;
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
}
