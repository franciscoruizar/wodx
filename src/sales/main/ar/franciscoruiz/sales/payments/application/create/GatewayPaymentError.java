package ar.franciscoruiz.sales.payments.application.create;

import ar.franciscoruiz.shared.domain.DomainError;

public final class GatewayPaymentError extends DomainError {
    public GatewayPaymentError(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
