package ar.franciscoruiz.accounts.purchases.domain.items.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreatePurchaseItemCommand implements Command {
    private final String  id;
    private final String  purchaseId;
    private final Integer quantity;
    private final String  membershipId;

    public CreatePurchaseItemCommand(String id, String purchaseId, Integer quantity, String membershipId) {
        this.id           = id;
        this.purchaseId   = purchaseId;
        this.quantity     = quantity;
        this.membershipId = membershipId;
    }

    public String id() {
        return this.id;
    }

    public String purchaseId() {
        return this.purchaseId;
    }

    public Integer quantity() {
        return this.quantity;
    }

    public String membershipId() {
        return this.membershipId;
    }
}
