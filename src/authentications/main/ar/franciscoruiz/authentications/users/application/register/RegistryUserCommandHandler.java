package ar.franciscoruiz.authentications.users.application.register;

import ar.franciscoruiz.authentications.users.domain.UserEmail;
import ar.franciscoruiz.authentications.users.domain.UserName;
import ar.franciscoruiz.authentications.users.domain.UserPhone;
import ar.franciscoruiz.authentications.users.domain.UserSurname;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class RegistryUserCommandHandler implements CommandHandler<RegistryUserCommand> {
    private final UserRegister creator;

    public RegistryUserCommandHandler(UserRegister creator) {
        this.creator = creator;
    }

    @Override
    public void handle(RegistryUserCommand command) {
        UserId      id      = new UserId(command.id());
        UserName    name    = new UserName(command.name());
        UserSurname surname = new UserSurname(command.surname());
        UserEmail   email   = new UserEmail(command.email());
        UserPhone   phone   = new UserPhone(command.phone());
        RoleId      roleId  = new RoleId(command.roleId());

        this.creator.create(id, name, surname, email, phone, roleId);
    }
}
