package ar.franciscoruiz.sales.payments.application;

import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.time.LocalDateTime;
import java.util.HashMap;

public final class PaymentResponse implements Response {
    private final String        id;
    private final String        method;
    private final Double        mount;
    private final String        purchaseId;
    private final LocalDateTime dateTime;

    public PaymentResponse(String id, String method, Double mount, String purchaseId, LocalDateTime dateTime) {
        this.id         = id;
        this.method     = method;
        this.mount      = mount;
        this.purchaseId = purchaseId;
        this.dateTime   = dateTime;
    }

    public static PaymentResponse fromAggregate(Payment payment) {
        return new PaymentResponse(
            payment.id().value(),
            payment.method().name(),
            payment.mount().value(),
            payment.purchaseId().value(),
            payment.dateTime()
        );
    }

    public HashMap<String, Object> toPrimitives() {
        HashMap<String, Object> response = new HashMap<>();

        response.put("id", this.id);
        response.put("method", this.method);
        response.put("mount", this.mount);
        response.put("purchase_id", this.purchaseId);
        response.put("date", this.dateTime);

        return response;
    }

    public String id() {
        return id;
    }

    public String method() {
        return method;
    }

    public Double mount() {
        return mount;
    }

    public String purchaseId() {
        return purchaseId;
    }

    public LocalDateTime dateTime() {
        return dateTime;
    }
}
