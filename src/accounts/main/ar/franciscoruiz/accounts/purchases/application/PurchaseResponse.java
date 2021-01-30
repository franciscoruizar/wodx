package ar.franciscoruiz.accounts.purchases.application;

import ar.franciscoruiz.accounts.purchases.domain.items.application.PurchaseItemsResponse;

import java.time.LocalDateTime;

public final class PurchaseResponse {
    private final String                id;
    private final String                description;
    private final LocalDateTime         date;
    private final String                userId;
    private final Double                totalPrice;
    private final PurchaseItemsResponse items;

    public PurchaseResponse(String id, String description, LocalDateTime date, String userId, Double totalPrice, PurchaseItemsResponse items) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.totalPrice  = totalPrice;
        this.items       = items;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public LocalDateTime date() {
        return this.date;
    }

    public String userId() {
        return this.userId;
    }

    public Double totalPrice() {
        return this.totalPrice;
    }

    public PurchaseItemsResponse items() {
        return this.items;
    }
}
