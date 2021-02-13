package ar.franciscoruiz.sales.products.application.material_product.create;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductWeight;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class MaterialProductCreator {
    private final ProductRepository repository;

    public MaterialProductCreator(ProductRepository repository) {
        this.repository = repository;
    }

    public void create(
        ProductId id,
        ProductTitle title,
        ProductDescription description,
        ProductPrice price,
        ProductIsActive isActive,
        CompanyId companyId,
        MaterialProductWeight weight
    ) {
        MaterialProduct product = new MaterialProduct(id, title, description, price, isActive, companyId, weight);

        this.repository.save(product);
    }
}
