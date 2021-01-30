package ar.franciscoruiz.accounts.user_memberships.application.create;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDate;

@Service
public final class CreateUserMembershipCommandHandler implements CommandHandler<CreateUserMembershipCommand> {
    private final UserMembershipCreator creator;

    public CreateUserMembershipCommandHandler(UserMembershipCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateUserMembershipCommand command) {
        UserMembershipId id           = new UserMembershipId(command.id());
        LocalDate        dateFrom     = command.dateFrom();
        MembershipId     membershipId = new MembershipId(command.membershipId());
        UserId           userId       = new UserId(command.userId());

        this.creator.create(id, dateFrom, membershipId, userId);
    }
}
