package ar.franciscoruiz.sales.items.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;

public final class ItemResponse implements Response {
    private final String  id;
    private final String  purchaseId;
    private final Integer quantity;
    private final Double  unitPrice;
    private final String  productId;

    public ItemResponse(String id, String purchaseId, Integer quantity, Double unitPrice, String productId) {
        this.id         = id;
        this.purchaseId = purchaseId;
        this.quantity   = quantity;
        this.unitPrice  = unitPrice;
        this.productId  = productId;
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

    public String productId() {
        return this.productId;
    }

    public Double unitPrice() {
        return this.unitPrice;
    }

    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> response = new HashMap<>();

        response.put("id", this.id);
        response.put("purchase_id", this.purchaseId);
        response.put("quantity", this.quantity);
        response.put("unit_price", this.unitPrice);
        response.put("product_id", this.productId);

        return response;
    }
}
