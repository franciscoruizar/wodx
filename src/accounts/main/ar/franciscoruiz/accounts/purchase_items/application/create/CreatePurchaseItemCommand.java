package ar.franciscoruiz.accounts.purchase_items.application.create;

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
        return id;
    }

    public String purchaseId() {
        return purchaseId;
    }

    public Integer quantity() {
        return quantity;
    }

    public String membershipId() {
        return membershipId;
    }
}
