package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;

public abstract class Product {
    private final ProductId          id;
    private final ProductTitle       title;
    private final ProductDescription description;
    private final ProductPrice       price;
    private final ProductIsActive    isActive;
    private final CompanyId          companyId;

    public Product(
        ProductId id,
        ProductTitle title,
        ProductDescription description,
        ProductPrice price,
        ProductIsActive isActive,
        CompanyId companyId
    ) {
        this.id          = id;
        this.title       = title;
        this.description = description;
        this.price       = price;
        this.isActive    = isActive;
        this.companyId   = companyId;
    }

    protected Product() {
        this.id          = null;
        this.title       = null;
        this.description = null;
        this.price       = null;
        this.isActive    = null;
        this.companyId   = null;
    }

    public ProductId id() {
        return id;
    }

    public ProductTitle title() {
        return title;
    }

    public ProductDescription description() {
        return description;
    }

    public ProductPrice price() {
        return price;
    }

    public ProductIsActive isActive() {
        return isActive;
    }

    public CompanyId companyId() {
        return companyId;
    }
}
