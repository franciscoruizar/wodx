package ar.franciscoruiz.apps.accounts.backend.controllers.purchases.shared.dto;

public final class PurchaseItemRequest {
    private String  id;
    private Integer quantity;
    private String  membershipId;

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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
