package ar.franciscoruiz.sales.products.application.membership;

import ar.franciscoruiz.sales.products.application.ProductResponse;
import ar.franciscoruiz.sales.products.domain.membership.Membership;

import java.util.HashMap;

public final class MembershipResponse extends ProductResponse {
    private final Integer numberDaysEnabled;

    public MembershipResponse(String id, String title, String description, Double price, Boolean isActive, String companyId, Integer numberDaysEnabled) {
        super(id, title, description, price, isActive, companyId);
        this.numberDaysEnabled = numberDaysEnabled;
    }

    public static MembershipResponse fromAggregate(Membership entity) {
        return new MembershipResponse(
            entity.id().value(),
            entity.title().value(),
            entity.description().value(),
            entity.price().value(),
            entity.isActive().value(),
            entity.companyId().value(),
            entity.numberDaysEnabled().value()
        );
    }

    @Override
    public HashMap<String, Object> toPrimitives() {
        var primitives = super.toPrimitives();

        primitives.put("number_days_enabled", this.numberDaysEnabled);

        return primitives;
    }

    public Integer numberDaysEnabled() {
        return numberDaysEnabled;
    }
}
