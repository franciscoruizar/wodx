package ar.franciscoruiz.sales.payments.domain;

import ar.franciscoruiz.sales.purchases.domain.PurchaseId;
import ar.franciscoruiz.sales.purchases.domain.PurchaseIdMother;

import java.time.LocalDateTime;

public final class PaymentMother {
    public static Payment create(
        PaymentId id,
        PaymentMethod method,
        PaymentMount mount,
        PurchaseId purchaseId,
        PaymentStatus status,
        LocalDateTime dateTime
    ) {
        return new Payment(id, method, mount, purchaseId, status, dateTime);
    }

    public static Payment random() {
        return create(
            PaymentIdMother.random(),
            PaymentMethodMother.random(),
            PaymentMountMother.random(),
            PurchaseIdMother.random(),
            PaymentStatusMother.random(),
            LocalDateTime.now()
        );
    }
}
