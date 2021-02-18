package ar.franciscoruiz.sales.purchases.application;

import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.payments.application.PaymentsResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.time.LocalDateTime;
import java.util.HashMap;

public final class PurchaseResponse implements Response {
    private final String           id;
    private final String           description;
    private final LocalDateTime    date;
    private final String           userId;
    private final String           companyId;
    private final Double           totalPrice;
    private final Double           totalPay;
    private final Boolean          isPay;
    private final ItemsResponse    items;
    private final PaymentsResponse payments;

    public PurchaseResponse(String id, String description, LocalDateTime date, String userId, String companyId, Double totalPrice, Double totalPay, Boolean isPay, ItemsResponse items, PaymentsResponse payments) {
        this.id          = id;
        this.description = description;
        this.date        = date;
        this.userId      = userId;
        this.companyId   = companyId;
        this.totalPrice  = totalPrice;
        this.totalPay    = totalPay;
        this.isPay       = isPay;
        this.items       = items;
        this.payments    = payments;
    }

    public HashMap<String, Object> toPrimitives() {
        HashMap<String, Object> response = new HashMap<>();

        response.put("id", this.id);
        response.put("description", this.description);
        response.put("date", this.date.toString());
        response.put("user_id", this.userId);
        response.put("company_id", this.companyId);
        response.put("total_price", this.totalPrice);
        response.put("total_pay", this.totalPay);
        response.put("isPay", this.isPay);
        response.put("items", this.items.toPrimitives());
        response.put("payments", this.payments.toPrimitives());

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

    public PaymentsResponse payments() {
        return payments;
    }
}
