package ar.franciscoruiz.sales.products.domain.membership;

import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository {
    void save(Membership membership);

    Optional<Membership> search(ProductId id);

    List<Membership> searchByCompany(CompanyId companyId);
}
