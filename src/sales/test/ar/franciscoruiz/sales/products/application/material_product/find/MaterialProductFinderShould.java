package ar.franciscoruiz.sales.products.application.material_product.find;

import ar.franciscoruiz.sales.products.ProductsModuleUnitTestCase;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductMother;
import org.junit.jupiter.api.Test;

final class MaterialProductFinderShould extends ProductsModuleUnitTestCase {
    @Test
    void find_a_valid_product() {
        MaterialProductFinder finder = new MaterialProductFinder(materialProductRepository);

        MaterialProduct product = MaterialProductMother.random();

        super.mockRepositorySearch(product);

        finder.find(product.id());
    }
}
