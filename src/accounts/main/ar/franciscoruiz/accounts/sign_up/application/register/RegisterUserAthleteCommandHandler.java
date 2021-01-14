package ar.franciscoruiz.accounts.sign_up.application.register;

import ar.franciscoruiz.accounts.sign_up.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class RegisterUserAthleteCommandHandler implements CommandHandler<RegisterUserAthleteCommand> {
    private final UserAthleteRegister register;

    public RegisterUserAthleteCommandHandler(UserAthleteRegister register) {
        this.register = register;
    }

    @Override
    public void handle(RegisterUserAthleteCommand command) {
        SignUpUserId       id       = new SignUpUserId(command.id());
        SignUpUserName     name     = new SignUpUserName(command.name());
        SignUpUserSurname  surname  = new SignUpUserSurname(command.surname());
        SignUpUserEmail    email    = new SignUpUserEmail(command.email());
        SignUpUserPassword password = new SignUpUserPassword(command.password());
        SignUpUserPhone    phone    = new SignUpUserPhone(command.phone());

        this.register.save(id, name, surname, email, password, phone);
    }
}
