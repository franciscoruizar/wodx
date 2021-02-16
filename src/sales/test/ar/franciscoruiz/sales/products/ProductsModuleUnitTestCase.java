package ar.franciscoruiz.sales.products;

import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductRepository;
import ar.franciscoruiz.sales.products.domain.membership.Membership;
import ar.franciscoruiz.sales.products.domain.membership.MembershipRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ProductsModuleUnitTestCase extends UnitTestCase {
    protected MaterialProductRepository materialProductRepository;
    protected MembershipRepository      membershipRepository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        materialProductRepository = mock(MaterialProductRepository.class);
        membershipRepository      = mock(MembershipRepository.class);
    }

    public void shouldSave(MaterialProduct entity) {
        this.materialProductRepository.save(entity);
    }

    public void shouldSave(Membership entity) {
        this.membershipRepository.save(entity);
    }

    public void shouldHaveSaved(MaterialProduct entity) {
        verify(materialProductRepository, atLeastOnce()).save(entity);
    }

    public void shouldHaveSaved(Membership entity) {
        verify(membershipRepository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(MaterialProduct entity) {
        Mockito.when(materialProductRepository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void mockRepositorySearch(Membership entity) {
        Mockito.when(membershipRepository.search(entity.id())).thenReturn(Optional.of(entity));
    }
}
