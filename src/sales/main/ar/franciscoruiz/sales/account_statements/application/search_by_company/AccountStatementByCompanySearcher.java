package ar.franciscoruiz.sales.account_statements.application.search_by_company;

import ar.franciscoruiz.sales.account_statements.application.AccountStatementResponse;
import ar.franciscoruiz.sales.account_statements.application.AccountStatementsResponse;
import ar.franciscoruiz.sales.items.application.ItemsResponse;
import ar.franciscoruiz.sales.items.application.find_by_purchase.FindItemByPurchaseQuery;
import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.application.membership.MembershipsResponse;
import ar.franciscoruiz.sales.products.application.membership.find.FindMembershipQuery;
import ar.franciscoruiz.sales.purchases.application.PurchasesResponse;
import ar.franciscoruiz.sales.purchases.application.search_by_company.SearchPurchaseByCompanyQuery;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AccountStatementByCompanySearcher {
    private final QueryBus queryBus;

    public AccountStatementByCompanySearcher(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    public AccountStatementsResponse find(CompanyId companyId) {
        List<AccountStatementResponse> responses = new ArrayList<>();
        PurchasesResponse              purchases = getPurchaseByCompany(companyId);

        for (var purchase : purchases.values()) {
            ItemsResponse items = getItemsByPurchase(purchase.id());

            MembershipsResponse memberships = getMembershipsByItem(items);

            for (var membership : memberships.values()) {
                int dateDifference = LocalDateTime.now().compareTo(purchase.date());

                responses.add(new AccountStatementResponse(
                    purchase,
                    items,
                    membership.numberDaysEnabled() >= dateDifference
                ));
            }
        }

        return new AccountStatementsResponse(responses);
    }

    private PurchasesResponse getPurchaseByCompany(CompanyId companyId) {
        return queryBus.ask(new SearchPurchaseByCompanyQuery(companyId.value()));
    }

    private ItemsResponse getItemsByPurchase(String purchaseId) {
        return queryBus.ask(new FindItemByPurchaseQuery(purchaseId));
    }

    private MembershipsResponse getMembershipsByItem(ItemsResponse items) {
        return new MembershipsResponse(
            items.values().stream()
                .map(item -> (MembershipResponse) queryBus.ask(new FindMembershipQuery(item.productId())))
                .collect(Collectors.toList())
        );
    }
}
