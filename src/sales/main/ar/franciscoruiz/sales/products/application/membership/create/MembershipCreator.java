package ar.franciscoruiz.sales.products.application.membership.create;

import ar.franciscoruiz.sales.products.domain.*;
import ar.franciscoruiz.sales.products.domain.membership.Membership;
import ar.franciscoruiz.sales.products.domain.membership.MembershipNumberDaysEnabled;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

@Service
public final class MembershipCreator {
    private final ProductRepository repository;

    public MembershipCreator(ProductRepository repository) {
        this.repository = repository;
    }

    public void create(
        ProductId id,
        ProductTitle title,
        ProductDescription description,
        ProductPrice price,
        ProductIsActive isActive,
        CompanyId companyId,
        MembershipNumberDaysEnabled numberDaysEnabled
    ) {
        Membership membership = new Membership(id, title, description, price, isActive, companyId, numberDaysEnabled);

        this.repository.save(membership);
    }
}
