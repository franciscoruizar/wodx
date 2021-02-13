package ar.franciscoruiz.sales.products.domain.material_product;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

public final class MaterialProduct extends Product {
    private final MaterialProductWeight weight;

    public MaterialProduct(
        ProductId id,
        ProductTitle title,
        ProductDescription description,
        ProductPrice price,
        ProductIsActive isActive,
        CompanyId companyId,
        MaterialProductWeight weight
    ) {
        super(id, title, description, price, isActive, companyId);
        this.weight = weight;
    }

    private MaterialProduct() {
        this.weight = null;
    }

    public MaterialProductWeight weight() {
        return weight;
    }
}
