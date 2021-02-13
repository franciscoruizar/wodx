package ar.franciscoruiz.sales.purchases.application.search_by_company;

import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.sales.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.util.stream.Collectors;

@Service
public final class PurchaseByCompanySearcher {
    private final PurchaseRepository repository;

    public PurchaseByCompanySearcher(PurchaseRepository repository) {
        this.repository = repository;
    }

    public PurchasesResponse search(CompanyId companyId) {
        return new PurchasesResponse(
            this.repository.searchByCompany(companyId)
                .stream()
                .map(PurchaseResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
