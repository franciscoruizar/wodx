package ar.franciscoruiz.accounts.purchases.application.search_by_company;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.purchase_items.application.PurchaseItemsResponse;
import ar.franciscoruiz.accounts.purchase_items.application.find_by_purchase.PurchaseItemByPurchaseFinder;
import ar.franciscoruiz.accounts.purchases.application.PurchaseResponse;
import ar.franciscoruiz.accounts.purchases.application.PurchasesResponse;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseId;
import ar.franciscoruiz.accounts.purchases.domain.PurchaseRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class PurchaseByCompanySearcher {
    private final PurchaseRepository           repository;
    private final PurchaseItemByPurchaseFinder itemFinder;

    public PurchaseByCompanySearcher(PurchaseRepository repository, PurchaseItemByPurchaseFinder itemFinder) {
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

    private PurchaseItemsResponse findItems(PurchaseId id) {
        return this.itemFinder.find(id);
    }
}
