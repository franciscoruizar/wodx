package ar.franciscoruiz.sales.payments;

import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class PaymentsModuleUnitTestCase extends UnitTestCase {
    protected PaymentRepository repository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(PaymentRepository.class);
    }

    public void shouldSave(Payment entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Payment entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Payment entity) {
        Mockito.when(repository.search(entity.id())).thenReturn(Optional.of(entity));
    }
}
