package ar.franciscoruiz.sales.purchases.application.search_by_user_company;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.stream.Collectors;

@Service
public final class PurchaseByUserCompanySearcher {
    private final PurchaseRepository repository;

    public PurchaseByUserCompanySearcher(PurchaseRepository repository) {
        this.repository = repository;
    }

    public PurchasesResponse search(UserId userId, CompanyId companyId) {
        return new PurchasesResponse(
            this.repository.searchByUserCompany(userId, companyId)
                .stream()
                .map(PurchaseResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
