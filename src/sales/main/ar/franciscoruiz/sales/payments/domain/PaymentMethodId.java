package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.Identifier;

public final class PaymentMethodId extends Identifier {
    public PaymentMethodId(String value) {
        super(value);
    }

    public PaymentMethodId() {
    }
}
