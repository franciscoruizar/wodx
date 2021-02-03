package ar.franciscoruiz.accounts.purchase_items.application.create;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemId;
import ar.franciscoruiz.accounts.purchase_items.domain.PurchaseItemQuantity;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreatePurchaseItemCommandHandler implements CommandHandler<CreatePurchaseItemCommand> {
    private final PurchaseItemCreator creator;

    public CreatePurchaseItemCommandHandler(PurchaseItemCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreatePurchaseItemCommand command) {
        PurchaseItemId       id           = new PurchaseItemId(command.id());
        PurchaseId           purchaseId   = new PurchaseId(command.purchaseId());
        PurchaseItemQuantity quantity     = new PurchaseItemQuantity(command.quantity());
        MembershipId         membershipId = new MembershipId(command.membershipId());

        this.creator.create(id, purchaseId, quantity, membershipId);
    }
}
