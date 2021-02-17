package ar.franciscoruiz.sales.purchases.application;

import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;

public final class ItemResponse implements Response {
    private final String  id;
    private final Integer quantity;
    private final Double  unitPrice;
    private final String  productId;

    public ItemResponse(String id, Integer quantity, Double unitPrice, String productId) {
        this.id        = id;
        this.quantity  = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
    }

    public String id() {
        return this.id;
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

    public ItemResponse fromAggregate(Item item) {
        return new ItemResponse(
            item.id().value(),
            item.quantity().value(),
            item.unitPrice().value(),
            item.productId().value()
        );
    }

    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> response = new HashMap<>();

        response.put("id", this.id);
        response.put("quantity", this.quantity);
        response.put("unit_price", this.unitPrice);
        response.put("product_id", this.productId);

        return response;
    }
}
