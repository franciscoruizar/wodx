package ar.franciscoruiz.sales.products.domain.material_product;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.companies.CompanyIdMother;

public final class MaterialProductMother {
    public static MaterialProduct create(
        ProductId id,
        ProductTitle title,
        ProductDescription description,
        ProductPrice price,
        CompanyId companyId,
        ProductIsActive isActive,
        MaterialProductWeight weight
    ) {
        return new MaterialProduct(
            id,
            title,
            description,
            price,
            isActive,
            companyId,
            weight
        );
    }

    public static MaterialProduct random() {
        return create(
            ProductIdMother.random(),
            ProductTitleMother.random(),
            ProductDescriptionMother.random(),
            ProductPriceMother.random(),
            CompanyIdMother.random(),
            ProductIsActiveMother.random(),
            MaterialProductWeightMother.random()
        );
    }
}
