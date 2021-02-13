package ar.franciscoruiz.sales.products.application.material_product.search_by_company;

import ar.franciscoruiz.sales.products.application.material_product.MaterialProductResponse;
import ar.franciscoruiz.sales.products.application.material_product.MaterialProductsResponse;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.products.domain.material_product.MaterialProduct;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.stream.Collectors;

@Service
public final class MaterialProductsByCompanySearcher {
    private final ProductRepository repository;

    public MaterialProductsByCompanySearcher(ProductRepository repository) {
        this.repository = repository;
    }

    public MaterialProductsResponse search(CompanyId companyId) {
        return new MaterialProductsResponse(
            this.repository.searchByCompany(companyId)
                .stream()
                .map(product -> MaterialProductResponse.fromAggregate((MaterialProduct) product))
                .collect(Collectors.toList())
        );
    }
}
