package ar.franciscoruiz.accounts.purchases.application;

import ar.franciscoruiz.accounts.items.application.ItemsResponse;
import ar.franciscoruiz.accounts.purchases.application.calculator.TotalPriceCalculator;
import ar.franciscoruiz.accounts.purchases.domain.Purchase;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;

public final class PurchaseResponse implements Response {
    private final String        id;
    private final String        description;
    private final LocalDateTime date;
    private final String        userId;
    private final String        companyId;
    private final Double        totalPrice;
    private final ItemsResponse items;

    public PurchaseResponse(String id, String description, LocalDateTime date, String userId, String companyId, Double totalPrice, ItemsResponse items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
        this.totalPrice  = totalPrice;
        this.items       = items;
    }

    public static PurchaseResponse fromAggregate(Purchase purchase) {
        return new PurchaseResponse(
            purchase.id().value(),
            purchase.description().value(),
            purchase.date(),
            purchase.userId().value(),
            purchase.companyId().value(),
            0.0,
            new ItemsResponse(Collections.emptyList())
        );
    }

    public static PurchaseResponse fromAggregate(Purchase purchase, ItemsResponse items) {
        return new PurchaseResponse(
            purchase.id().value(),
            purchase.description().value(),
            purchase.date(),
            purchase.userId().value(),
            purchase.companyId().value(),
            new TotalPriceCalculator(items).calculate(),
            items
        );
    }

    public HashMap<String, Object> toPrimitives() {
        HashMap<String, Object> response = new HashMap<>();

        response.put("id", this.id);
        response.put("description", this.description);
        response.put("date", this.date);
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
