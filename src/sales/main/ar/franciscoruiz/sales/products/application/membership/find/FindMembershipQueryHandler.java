package ar.franciscoruiz.sales.products.application.membership.find;

import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindMembershipQueryHandler implements QueryHandler<FindMembershipQuery, MembershipResponse> {
    private final MembershipFinder finder;

    public FindMembershipQueryHandler(MembershipFinder finder) {
        this.finder = finder;
    }

    @Override
    public MembershipResponse handle(FindMembershipQuery query) {
        ProductId id = new ProductId(query.id());

        return this.finder.find(id);
    }
}
