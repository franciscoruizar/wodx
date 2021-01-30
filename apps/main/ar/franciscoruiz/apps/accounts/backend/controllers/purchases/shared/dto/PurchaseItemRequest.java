package ar.franciscoruiz.apps.accounts.backend.controllers.purchases.shared.dto;

import ar.franciscoruiz.accounts.purchases.application.create.CreatePurchaseCommand;
import ar.franciscoruiz.accounts.purchases.domain.items.application.create.CreatePurchaseItemCommand;

public final class PurchaseItemRequest {
    private String  id;
    private String  purchaseId;
    private Integer quantity;
    private String  membershipId;

    public PurchaseItemRequest(String id, String purchaseId, Integer quantity, String membershipId) {
        this.id           = id;
        this.purchaseId   = purchaseId;
        this.quantity     = quantity;
        this.membershipId = membershipId;
    }

    public static CreatePurchaseItemCommand parseRequest(PurchaseItemRequest request) {
        return new CreatePurchaseItemCommand(
            request.id(),
            request.purchaseId(),
            request.quantity(),
            request.membershipId()
        );
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String purchaseId() {
        return this.purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer quantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String membershipId() {
        return this.membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }
}
