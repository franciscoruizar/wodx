package ar.franciscoruiz.sales.payments.infrastructure.payment_gateways;

import ar.franciscoruiz.sales.payments.domain.PaymentGateway;
import ar.franciscoruiz.sales.payments.domain.PaymentMethod;
import ar.franciscoruiz.shared.domain.Service;

import java.util.HashMap;

@Service
public final class PaymentGatewayFactory {
    private final HashMap<PaymentMethod, PaymentGateway> values;

    public PaymentGatewayFactory() {
        this.values = new HashMap<>() {{
            put(PaymentMethod.CASH, new FakerPaymentGateway());
        }};
    }

    public PaymentGateway instance(PaymentMethod paymentMethod) {
        return values.get(paymentMethod);
    }
}
