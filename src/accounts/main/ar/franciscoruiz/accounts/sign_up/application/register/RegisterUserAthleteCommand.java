package ar.franciscoruiz.accounts.sign_up.application.register;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class RegisterUserAthleteCommand implements Command {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final String phone;

    public RegisterUserAthleteCommand(String id, String name, String surname, String email, String password, String phone) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.email    = email;
        this.password = password;
        this.phone    = phone;
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
}
