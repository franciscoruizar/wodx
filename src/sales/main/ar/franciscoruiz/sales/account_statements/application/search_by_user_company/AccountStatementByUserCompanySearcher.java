package ar.franciscoruiz.sales.account_statements.application.search_by_user_company;

import ar.franciscoruiz.sales.account_statements.application.AccountStatementResponse;
import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.items.application.find_by_purchase.FindItemByPurchaseQuery;
import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.application.membership.MembershipsResponse;
import ar.franciscoruiz.sales.products.application.membership.find.FindMembershipQuery;
import ar.franciscoruiz.sales.purchases.application.PurchaseResponse;
import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.sales.purchases.application.search_by_user_company.SearchPurchaseByUserCompanyQuery;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.companies.CompanyId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public final class AccountStatementByUserCompanySearcher {
    private final QueryBus queryBus;

    public AccountStatementByUserCompanySearcher(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    public AccountStatementResponse find(UserId userId, CompanyId companyId) {
        PurchaseResponse lastPurchase = getLastPurchaseByUserCompany(userId, companyId);
        ItemsResponse    items        = getItemsByPurchase(lastPurchase);

        MembershipsResponse memberships = getMembershipsByItem(items);

        int dateDifference = LocalDateTime.now().compareTo(lastPurchase.date());

        for (var membership : memberships.values()) {
            if (membership.numberDaysEnabled() >= dateDifference) {
                return new AccountStatementResponse(lastPurchase, items, true);
            }
        }

        return new AccountStatementResponse(lastPurchase, items, false);
    }


    private PurchasesResponse getPurchasesByUserCompany(UserId userId, CompanyId companyId) {
        return queryBus.ask(new SearchPurchaseByUserCompanyQuery(userId.value(), companyId.value()));
    }

    private PurchaseResponse getLastPurchaseByUserCompany(UserId userId, CompanyId companyId) {
        PurchasesResponse purchases = getPurchasesByUserCompany(userId, companyId);

        return purchases.values()
            .stream()
            .sorted(Comparator.comparing(PurchaseResponse::date).reversed())
            .collect(Collectors.toList())
            .stream()
            .findFirst()
            .get();
    }

    private ItemsResponse getItemsByPurchase(PurchaseResponse lastPurchase) {
        return queryBus.ask(new FindItemByPurchaseQuery(lastPurchase.id()));
    }

    private MembershipsResponse getMembershipsByItem(ItemsResponse items) {
        return new MembershipsResponse(
            items.values().stream()
                .map(item -> (MembershipResponse) queryBus.ask(new FindMembershipQuery(item.productId())))
                .collect(Collectors.toList())
        );
    }
}
