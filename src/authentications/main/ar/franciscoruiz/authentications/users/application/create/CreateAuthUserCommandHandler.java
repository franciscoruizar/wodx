package ar.franciscoruiz.authentications.users.application.create;

import ar.franciscoruiz.authentications.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.roles.RoleId;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class CreateAuthUserCommandHandler implements CommandHandler<CreateAuthUserCommand> {
    private final AuthUserCreator creator;

    public CreateAuthUserCommandHandler(AuthUserCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateAuthUserCommand command) {
        UserId       id       = new UserId(command.id());
        UserName     name     = new UserName(command.name());
        UserSurname  surname  = new UserSurname(command.surname());
        UserEmail    email    = new UserEmail(command.email());
        UserPhone    phone    = new UserPhone(command.phone());
        UserIsActive isActive = new UserIsActive(command.isActive());
        RoleId       roleId   = new RoleId(command.roleId());

        this.creator.create(id, name, surname, email, phone, isActive, roleId);
    }
}
