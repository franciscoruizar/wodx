package ar.franciscoruiz.sales.products.application.material_product.search_by_company;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductResponse;
import ar.franciscoruiz.sales.products.application.material_product.MaterialProductsResponse;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProductRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.stream.Collectors;

@Service
public final class MaterialProductsByCompanySearcher {
    private final MaterialProductRepository repository;

    public MaterialProductsByCompanySearcher(MaterialProductRepository repository) {
        this.repository = repository;
    }

    public MaterialProductsResponse search(CompanyId companyId) {
        return new MaterialProductsResponse(
            this.repository.searchByCompany(companyId)
                .stream()
                .map(MaterialProductResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
