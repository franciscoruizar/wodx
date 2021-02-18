package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.sales.purchases.domain.PurchaseId;

import java.time.LocalDateTime;
import java.util.List;

public final class Payment {
    private final PaymentId       id;
    private final PaymentMethodId method;
    private final PaymentMount    mount;
    private final PurchaseId      purchaseId;
    private final PaymentStatus   state;
    private final LocalDateTime   date;

    public Payment(PaymentId id, PaymentMethod method, PaymentMount mount, PurchaseId purchaseId, PaymentStatus state, LocalDateTime date) {
        this.id         = id;
        this.method     = method.id();
        this.mount      = mount;
        this.purchaseId = purchaseId;
        this.state      = state;
        this.date       = date;
    }

    private Payment() {
        this.id         = null;
        this.method     = null;
        this.mount      = null;
        this.purchaseId = null;
        this.state      = null;
        this.date       = null;
    }

    public static Double totalPay(List<Payment> payments) {
        double totalPay = 0.0;

        for (var payment : payments)
            totalPay += payment.mount().value();

        return totalPay;
    }

    public PaymentId id() {
        return id;
    }

    public PaymentMethod method() {
        return PaymentMethod.fromString(method.value()).orElseThrow(() -> new PaymentMethodNotExist(this.method));
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

    public LocalDateTime date() {
        return date;
    }
}
