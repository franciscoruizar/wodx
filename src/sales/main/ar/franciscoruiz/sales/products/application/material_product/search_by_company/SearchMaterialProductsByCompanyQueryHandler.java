package ar.franciscoruiz.sales.products.application.material_product.search_by_company;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class SearchMaterialProductsByCompanyQueryHandler implements QueryHandler<SearchMaterialProductsByCompanyQuery, MaterialProductsResponse> {
    private final MaterialProductsByCompanySearcher searcher;

    public SearchMaterialProductsByCompanyQueryHandler(MaterialProductsByCompanySearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public MaterialProductsResponse handle(SearchMaterialProductsByCompanyQuery query) {
        CompanyId companyId = new CompanyId(query.companyId());

        return this.searcher.search(companyId);
    }
}
