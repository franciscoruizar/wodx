package ar.franciscoruiz.authentications.users.application.register;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class RegisterUserCommand implements Command {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;
    private final String phone;
    private final String roleId;

    public RegisterUserCommand(
        String id,
        String name,
        String surname,
        String email,
        String phone,
        String roleId
    ) {
        this.id      = id;
        this.name    = name;
        this.surname = surname;
        this.email   = email;
        this.phone   = phone;
        this.roleId  = roleId;
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

    public String roleId() {
        return this.roleId;
    }
}
