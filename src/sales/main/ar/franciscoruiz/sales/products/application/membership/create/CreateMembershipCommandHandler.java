package ar.franciscoruiz.sales.products.application.membership.create;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.sales.products.domain.membership.MembershipNumberDaysEnabled;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class CreateMembershipCommandHandler implements CommandHandler<CreateMembershipCommand> {
    private final MembershipCreator creator;

    public CreateMembershipCommandHandler(MembershipCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateMembershipCommand command) {
        ProductId                   id                = new ProductId(command.id());
        ProductTitle                title             = new ProductTitle(command.title());
        ProductDescription          description       = new ProductDescription(command.description());
        ProductPrice                price             = new ProductPrice(command.price());
        ProductIsActive             isActive          = new ProductIsActive(command.isActive());
        CompanyId                   companyId         = new CompanyId(command.companyId());
        MembershipNumberDaysEnabled numberDaysEnabled = new MembershipNumberDaysEnabled(command.numberDaysEnabled());

        this.creator.create(
            id,
            title,
            description,
            price,
            isActive,
            companyId,
            numberDaysEnabled
        );
    }
}
