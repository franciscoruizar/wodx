package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.vo.BooleanValueObject;

public final class PaymentStatus extends BooleanValueObject {
    public PaymentStatus(Boolean value) {
        super(value);
    }

    private PaymentStatus() {
        super(null);
    }
}
