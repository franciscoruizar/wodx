package ar.franciscoruiz.accounts.memberships.application.create;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.memberships.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateMembershipCommandHandler implements CommandHandler<CreateMembershipCommand> {
    private final MembershipCreator creator;

    public CreateMembershipCommandHandler(MembershipCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateMembershipCommand command) {
        MembershipId                id                = new MembershipId(command.id());
        MembershipDescription       description       = new MembershipDescription(command.description());
        MembershipNumberDaysEnabled numberDaysEnabled = new MembershipNumberDaysEnabled(command.numberDaysEnabled());
        MembershipPrice             price             = new MembershipPrice(command.price());
        CompanyId                   companyId         = new CompanyId(command.companyId());
        MembershipIsActive          isActive          = new MembershipIsActive(command.isActive());

        this.creator.create(id, description, numberDaysEnabled, price, companyId, isActive);
    }
}
