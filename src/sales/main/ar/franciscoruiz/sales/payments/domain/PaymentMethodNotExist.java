package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class PaymentMethodNotExist extends DomainError {
    public PaymentMethodNotExist(PaymentMethodId id) {
        super("payment_method_not_exist", String.format("The payment method <%s> doesn't exist", id.value()));
    }
}
