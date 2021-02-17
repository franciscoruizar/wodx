package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.BooleanMother;

public final class PaymentStatusMother {
    public static PaymentStatus create(Boolean value) {
        return new PaymentStatus(value);
    }

    public static PaymentStatus random() {
        return create(BooleanMother.random());
    }
}
