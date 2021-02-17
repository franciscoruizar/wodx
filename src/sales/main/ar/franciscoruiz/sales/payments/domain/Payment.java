package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.time.LocalDateTime;

public final class Payment {
    private final PaymentId     id;
    private final PaymentMethod method;
    private final PaymentMount  mount;
    private final PurchaseId    purchaseId;
    private final PaymentStatus state;
    private final LocalDateTime dateTime;

    public Payment(PaymentId id, PaymentMethod method, PaymentMount mount, PurchaseId purchaseId, PaymentStatus state, LocalDateTime dateTime) {
        this.id         = id;
        this.method     = method;
        this.mount      = mount;
        this.purchaseId = purchaseId;
        this.state      = state;
        this.dateTime   = dateTime;
    }

    private Payment() {
        this.id         = null;
        this.method     = null;
        this.mount      = null;
        this.purchaseId = null;
        this.state      = null;
        this.dateTime   = null;
    }

    public PaymentId id() {
        return id;
    }

    public PaymentMethod method() {
        return method;
    }

    public PaymentMount mount() {
        return mount;
    }

    public PurchaseId purchaseId() {
        return purchaseId;
    }

    public PaymentStatus state() {
        return state;
    }

    public LocalDateTime dateTime() {
        return dateTime;
    }
}
