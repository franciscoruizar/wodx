package ar.franciscoruiz.sales.products.domain;

import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(Product product);

    Optional<Product> search(ProductId id);

    List<Product> searchByCompany(CompanyId companyId);
}
