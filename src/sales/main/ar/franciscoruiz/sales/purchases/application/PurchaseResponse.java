package ar.franciscoruiz.sales.purchases.application;

import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class PurchaseResponse implements Response {
    private final String        id;
    private final String        description;
    private final LocalDateTime date;
    private final String        userId;
    private final String        companyId;
    private final Double        totalPrice;
    private final ItemsResponse items;

    public PurchaseResponse(String id, String description, LocalDateTime date, String userId, String companyId, Double totalPrice, List<Item> items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
        this.totalPrice  = totalPrice;
        this.items       = new ItemsResponse(
            items.stream().map(item -> new ItemResponse(
                item.id().value(),
                item.quantity().value(),
                item.unitPrice().value(),
                item.productId().value()
            )).collect(Collectors.toList())
        );
    }

    public PurchaseResponse(String id, String description, LocalDateTime date, String userId, String companyId, Double totalPrice, ItemsResponse items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
        this.totalPrice  = totalPrice;
        this.items       = items;
    }

    public static PurchaseResponse fromAggregate(Purchase purchase, Double totalPrice, List<Item> items) {
        return new PurchaseResponse(
            purchase.id().value(),
            purchase.description().value(),
            purchase.date(),
            purchase.userId().value(),
            purchase.companyId().value(),
            totalPrice,
            items
        );
    }

    public HashMap<String, Object> toPrimitives() {
        HashMap<String, Object> response = new HashMap<>();

        response.put("id", this.id);
        response.put("description", this.description);
        response.put("date", this.date.toString());
        response.put("user_id", this.userId);
        response.put("company_id", this.companyId);
        response.put("total_price", this.totalPrice);
        response.put("items", this.items.toPrimitives());

        return response;
    }

    public String id() {
        return id;
    }

    public String description() {
        return description;
    }

    public LocalDateTime date() {
        return date;
    }

    public String userId() {
        return userId;
    }

    public String companyId() {
        return companyId;
    }

    public Double totalPrice() {
        return totalPrice;
    }

    public ItemsResponse items() {
        return items;
    }
}
