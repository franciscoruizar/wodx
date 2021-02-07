package ar.franciscoruiz.accounts.items.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;

public final class ItemResponse implements Response {
    private final String  id;
    private final String  purchaseId;
    private final Integer quantity;
    private final Double  price;
    private final String  membershipId;

    public ItemResponse(String id, String purchaseId, Integer quantity, Double price, String membershipId) {
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

    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> response = new HashMap<>();

        response.put("id", this.id);
        response.put("purchaseId", this.purchaseId);
        response.put("quantity", this.quantity);
        response.put("price", this.price);
        response.put("membershipId", this.membershipId);

        return response;
    }
}
