package ar.franciscoruiz.accounts.purchases.application.search_by_company;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.items.application.ItemsResponse;
import ar.franciscoruiz.accounts.items.application.find_by_purchase.ItemByPurchaseFinder;
import ar.franciscoruiz.accounts.purchases.application.PurchaseResponse;
import ar.franciscoruiz.accounts.purchases.application.PurchasesResponse;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class PurchaseByCompanySearcher {
    private final PurchaseRepository   repository;
    private final ItemByPurchaseFinder itemFinder;

    public PurchaseByCompanySearcher(PurchaseRepository repository, ItemByPurchaseFinder itemFinder) {
        this.repository = repository;
        this.itemFinder = itemFinder;
    }

    public PurchasesResponse search(CompanyId companyId) {
        return new PurchasesResponse(
            this.repository.searchByCompany(companyId)
                .stream()
                .map(purchase -> PurchaseResponse.fromAggregate(purchase, findItems(purchase.id())))
                .collect(Collectors.toList())
        );
    }

    private ItemsResponse findItems(PurchaseId id) {
        return this.itemFinder.find(id);
    }
}
