package ar.franciscoruiz.sales.products.domain.material_product;

import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.List;
import java.util.Optional;

public interface MaterialProductRepository {
    void save(MaterialProduct product);

    Optional<MaterialProduct> search(ProductId id);

    List<MaterialProduct> searchByCompany(CompanyId companyId);
}
