package ar.franciscoruiz.accounts.memberships.application;

import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;

public final class MembershipResponse implements Response {
    private final String  id;
    private final String  description;
    private final Integer numberDaysEnabled;
    private final Double  price;
    private final String  companyId;
    private final Boolean isActive;

    public MembershipResponse(String id, String description, Integer numberDaysEnabled, Double price, String companyId, Boolean isActive) {
        this.id                = id;
        this.description       = description;
        this.numberDaysEnabled = numberDaysEnabled;
        this.price             = price;
        this.companyId         = companyId;
        this.isActive          = isActive;
    }

    public static MembershipResponse fromAggregate(Membership membership) {
        return new MembershipResponse(
            membership.id().value(),
            membership.description().value(),
            membership.numberDaysEnabled().value(),
            membership.price().value(),
            membership.companyId().value(),
            membership.isActive().value()
        );
    }

    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> response = new HashMap<>();

        response.put("id", this.id);
        response.put("description", this.description);
        response.put("number_days_enabled", this.numberDaysEnabled);
        response.put("price", this.price);
        response.put("company_id", this.companyId);
        response.put("is_active", this.isActive);

        return response;
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }

    public Integer numberDaysEnabled() {
        return this.numberDaysEnabled;
    }

    public Double price() {
        return this.price;
    }

    public String companyId() {
        return this.companyId;
    }

    public Boolean isActive() {
        return this.isActive;
    }
}
