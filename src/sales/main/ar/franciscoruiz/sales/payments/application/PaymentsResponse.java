package ar.franciscoruiz.sales.payments.application;

import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class PaymentsResponse implements Response {
    private final List<PaymentResponse> values;

    public PaymentsResponse(List<PaymentResponse> values) {
        this.values = values;
    }

    public static PaymentsResponse fromAggregate(List<Payment> payments) {
        return new PaymentsResponse(
            payments
                .stream()
                .map(PaymentResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }

    public List<HashMap<String, Object>> toPrimitives() {
        return this.values
            .stream()
            .map(PaymentResponse::toPrimitives)
            .collect(Collectors.toList());
    }

    public List<PaymentResponse> values() {
        return values;
    }
}
