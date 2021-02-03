package ar.franciscoruiz.accounts.purchase_items.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class PurchaseItemResponse implements Response {
    private final String  id;
    private final String  purchaseId;
    private final Integer quantity;
    private final Double  price;
    private final String  membershipId;

    public PurchaseItemResponse(String id, String purchaseId, Integer quantity, Double price, String membershipId) {
        this.id           = id;
        this.purchaseId   = purchaseId;
        this.quantity     = quantity;
        this.price        = price;
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

    public Double price() {
        return this.price;
    }
}
