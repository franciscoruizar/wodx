package ar.franciscoruiz.sales.products.application.membership.find;

import ar.franciscoruiz.sales.products.application.membership.MembershipResponse;
import ar.franciscoruiz.sales.products.domain.ProductId;
import ar.franciscoruiz.sales.products.domain.ProductNotExist;
import ar.franciscoruiz.sales.products.domain.ProductRepository;
import ar.franciscoruiz.sales.products.domain.membership.Membership;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class MembershipFinder {
    private final ProductRepository repository;

    public MembershipFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public MembershipResponse find(ProductId id) {
        return this.repository.search(id)
            .map(product -> MembershipResponse.fromAggregate((Membership) product))
            .orElseThrow(() -> new ProductNotExist(id));
    }
}
