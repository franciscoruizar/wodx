package ar.franciscoruiz.authentications.users.application.register;

import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserEmail;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserName;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserPhone;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserSurname;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class RegisterUserCommandHandler implements CommandHandler<RegisterUserCommand> {
    private final UserRegister creator;

    public RegisterUserCommandHandler(UserRegister creator) {
        this.creator = creator;
    }

    @Override
    public void handle(RegisterUserCommand command) {
        UserId                     id      = new UserId(command.id());
        AuthenticationsUserName    name    = new AuthenticationsUserName(command.name());
        AuthenticationsUserSurname surname = new AuthenticationsUserSurname(command.surname());
        AuthenticationsUserEmail   email   = new AuthenticationsUserEmail(command.email());
        AuthenticationsUserPhone   phone   = new AuthenticationsUserPhone(command.phone());
        RoleId                     roleId  = new RoleId(command.roleId());

        this.creator.create(id, name, surname, email, phone, roleId);
    }
}
