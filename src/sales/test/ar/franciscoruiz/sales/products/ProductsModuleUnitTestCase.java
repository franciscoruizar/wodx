package ar.franciscoruiz.sales.products;

import ar.franciscoruiz.sales.products.domain.Product;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ProductsModuleUnitTestCase extends UnitTestCase {
    protected ProductRepository repository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(ProductRepository.class);
    }

    public void shouldSave(Product entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Product entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Product entity) {
        Mockito.when(repository.search(entity.id())).thenReturn(Optional.of(entity));
    }
}
