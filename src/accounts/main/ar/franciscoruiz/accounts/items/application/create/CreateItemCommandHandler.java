package ar.franciscoruiz.accounts.items.application.create;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.items.domain.ItemId;
import ar.franciscoruiz.accounts.items.domain.ItemQuantity;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateItemCommandHandler implements CommandHandler<CreateItemCommand> {
    private final ItemCreator creator;

    public CreateItemCommandHandler(ItemCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateItemCommand command) {
        ItemId     id         = new ItemId(command.id());
        PurchaseId   purchaseId   = new PurchaseId(command.purchaseId());
        ItemQuantity quantity     = new ItemQuantity(command.quantity());
        MembershipId membershipId = new MembershipId(command.membershipId());

        this.creator.create(id, purchaseId, quantity, membershipId);
    }
}
