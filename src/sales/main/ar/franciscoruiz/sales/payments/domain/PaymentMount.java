package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.vo.DoubleValueObject;

public final class PaymentMount extends DoubleValueObject {
    public PaymentMount(Double value) {
        super(value);
    }

    private PaymentMount() {
        super(null);
    }
}
