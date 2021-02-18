package ar.franciscoruiz.sales.purchases;

import ar.franciscoruiz.sales.items.domain.Item;
import ar.franciscoruiz.sales.items.domain.ItemRepository;
import ar.franciscoruiz.sales.payments.domain.Payment;
import ar.franciscoruiz.sales.payments.domain.PaymentRepository;
import ar.franciscoruiz.sales.products.domain.Product;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class PurchasesModuleUnitTestCase extends UnitTestCase {
    protected PurchaseRepository repository;
    protected ItemRepository     itemRepository;
    protected ProductRepository  productRepository;
    protected PaymentRepository  paymentRepository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository        = mock(PurchaseRepository.class);
        itemRepository    = mock(ItemRepository.class);
        productRepository = mock(ProductRepository.class);
        paymentRepository = mock(PaymentRepository.class);
    }

    public void shouldSave(Purchase entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Purchase entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Purchase entity) {
        Mockito.when(repository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void mockRepositoryFindAll(CompanyId companyId, List<Purchase> entities) {
        Mockito.when(repository.searchByCompany(companyId)).thenReturn(entities);
    }

    public void shouldSave(Product entity) {
        this.productRepository.save(entity);
    }

    public void shouldHaveSaved(Product entity) {
        verify(productRepository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Product entity) {
        Mockito.when(productRepository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void shouldSave(Item entity) {
        this.itemRepository.save(entity);
    }

    public void shouldHaveSaved(Item entity) {
        verify(itemRepository, atLeastOnce()).save(entity);
    }

    public void shouldSave(Payment entity) {
        this.paymentRepository.save(entity);
    }

    public void shouldHaveSaved(Payment entity) {
        verify(paymentRepository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Payment entity) {
        Mockito.when(paymentRepository.search(entity.id())).thenReturn(Optional.of(entity));
    }
}
