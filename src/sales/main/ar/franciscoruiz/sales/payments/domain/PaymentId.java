package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.Identifier;

public final class PaymentId extends Identifier {
    public PaymentId(String value) {
        super(value);
    }

    private PaymentId() {
    }
}
