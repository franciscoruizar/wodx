package ar.franciscoruiz.sales.payments.domain;

import java.util.Random;

public final class PaymentMethodMother {
    public static PaymentMethod create(String value) {
        return PaymentMethod.valueOf(value);
    }

    public static PaymentMethod random() {
        Random random        = new Random();
        int    randomElement = random.nextInt(PaymentMethod.values().length);
        return PaymentMethod.values()[randomElement];
    }
}
