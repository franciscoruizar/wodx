package ar.franciscoruiz.sales.purchases;

import ar.franciscoruiz.sales.products.domain.Product;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.purchases.domain.Purchase;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.sales.purchases.domain.items.Item;
import ar.franciscoruiz.sales.purchases.domain.items.ItemRepository;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class PurchasesModuleUnitTestCase extends UnitTestCase {
    protected PurchaseRepository repository;
    protected ProductRepository  productRepository;
    protected ItemRepository     itemRepository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository        = mock(PurchaseRepository.class);
        productRepository = mock(ProductRepository.class);
        itemRepository    = mock(ItemRepository.class);
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

    public void shouldProductSave(Product entity) {
        this.productRepository.save(entity);
    }

    public void shouldProductHaveSaved(Product entity) {
        verify(productRepository, atLeastOnce()).save(entity);
    }

    public void mockProductRepositorySearch(Product entity) {
        Mockito.when(productRepository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void shouldItemSave(Item entity) {
        this.itemRepository.save(entity);
    }

    public void shouldItemHaveSaved(Item entity) {
        verify(itemRepository, atLeastOnce()).save(entity);
    }
}
