package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.DoubleMother;

public final class PaymentMountMother {
    public static PaymentMount create(Double value) {
        return new PaymentMount(value);
    }

    public static PaymentMount random() {
        return create(DoubleMother.random());
    }
}
