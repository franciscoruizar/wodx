package ar.franciscoruiz.sales.products.application.material_product.create;

import ar.franciscoruiz.sales.products.ProductsModuleUnitTestCase;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductMother;
import org.junit.jupiter.api.Test;

class MaterialProductCreatorShould extends ProductsModuleUnitTestCase {
    @Test
    void create_a_valid_product() {
        MaterialProductCreator creator = new MaterialProductCreator(repository);

        MaterialProduct product = MaterialProductMother.random();

        super.mockRepositorySearch(product);

        creator.create(product.id(), product.title(), product.description(), product.price(), product.isActive(), product.companyId(), product.weight());

        shouldSave(product);
        shouldHaveSaved(product);
    }
}
