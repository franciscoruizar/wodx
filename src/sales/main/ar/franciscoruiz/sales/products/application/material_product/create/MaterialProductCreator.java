package ar.franciscoruiz.sales.products.application.material_product.create;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductRepository;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductWeight;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class MaterialProductCreator {
    private final MaterialProductRepository repository;

    public MaterialProductCreator(MaterialProductRepository repository) {
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
