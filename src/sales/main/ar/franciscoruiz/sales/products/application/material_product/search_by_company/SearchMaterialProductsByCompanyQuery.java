package ar.franciscoruiz.sales.products.application.material_product.search_by_company;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchMaterialProductsByCompanyQuery implements Query {
    private final String companyId;

    public SearchMaterialProductsByCompanyQuery(String companyId) {
        this.companyId = companyId;
    }

    public String companyId() {
        return companyId;
    }
}
