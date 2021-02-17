package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class PaymentIdMother {
    public static PaymentId create(String value) {
        return new PaymentId(value);
    }

    public static PaymentId random() {
        return create(UuidMother.random());
    }
}
