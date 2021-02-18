package ar.franciscoruiz.sales.payments;

import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class PaymentsModuleUnitTestCase extends UnitTestCase {
    protected PaymentRepository  repository;
    protected PurchaseRepository purchaseRepository;
    protected ItemRepository     itemRepository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository         = mock(PaymentRepository.class);
        purchaseRepository = mock(PurchaseRepository.class);
        itemRepository     = mock(ItemRepository.class);
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

    public void shouldSave(Purchase entity) {
        this.purchaseRepository.save(entity);
    }

    public void shouldHaveSaved(Purchase entity) {
        verify(purchaseRepository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Purchase entity) {
        Mockito.when(purchaseRepository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void shouldSave(Item entity) {
        this.itemRepository.save(entity);
    }

    public void shouldHaveSaved(Item entity) {
        verify(itemRepository, atLeastOnce()).save(entity);
    }
}
