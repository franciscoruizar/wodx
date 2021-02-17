package ar.franciscoruiz.sales.payments.application.create;

import ar.franciscoruiz.sales.payments.PaymentsModuleUnitTestCase;
import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentMother;
import org.junit.jupiter.api.Test;

final class PaymentCreatorShould extends PaymentsModuleUnitTestCase {
    @Test
    void create_a_valid_payment() {
        PaymentCreator creator = new PaymentCreator(repository);

        Payment payment = PaymentMother.random();

        super.mockRepositorySearch(payment);

        creator.create(
            payment.id(),
            payment.method(),
            payment.mount(),
            payment.purchaseId(),
            payment.dateTime()
        );

        shouldSave(payment);
        shouldHaveSaved(payment);
    }
}
