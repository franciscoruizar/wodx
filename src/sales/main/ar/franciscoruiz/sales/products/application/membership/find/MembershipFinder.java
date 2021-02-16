package ar.franciscoruiz.sales.products.application.membership.find;

import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductNotExist;
import ar.franciscoruiz.sales.products.domain.membership.MembershipRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MembershipFinder {
    private final MembershipRepository repository;

    public MembershipFinder(MembershipRepository repository) {
        this.repository = repository;
    }

    public MembershipResponse find(ProductId id) {
        return this.repository.search(id)
            .map(MembershipResponse::fromAggregate)
            .orElseThrow(() -> new ProductNotExist(id));
    }
}
