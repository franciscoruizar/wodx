package ar.franciscoruiz.sales.payments.domain;

import java.util.Arrays;
import java.util.Optional;

public enum PaymentMethod {
    CASH("f0d3094f-0171-436d-830f-b7930145dc8f"),
    DEBIT_CARD("0e3f2d8d-819a-4ed1-8ad4-c00ba719ef07"),
    CREDIT_CARD("6a8d7d6f-bcc3-4c54-8a8b-3ef10f7d0fad"),
    PAYPAL("4bda3c14-21a4-4f2e-b696-981be6294161"),
    MERCADO_PAGO("1754ffb7-6a6f-4677-a127-4343c223951e");

    private final String id;

    PaymentMethod(String id) {
        this.id = id;
    }

    public static Optional<PaymentMethod> fromString(String text) {
        return Arrays.stream(values())
            .filter(method -> method.id.equalsIgnoreCase(text))
            .findFirst();
    }

    public PaymentMethodId id() {
        return new PaymentMethodId(id);
    }
}
