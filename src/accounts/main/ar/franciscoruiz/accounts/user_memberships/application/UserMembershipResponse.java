package ar.franciscoruiz.accounts.user_memberships.application;

import ar.franciscoruiz.accounts.user_memberships.domain.UserMembership;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public final class UserMembershipResponse implements Response {
    private final String    id;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;
    private final String    membershipId;
    private final String    userId;

    public UserMembershipResponse(String id, LocalDate dateFrom, LocalDate dateTo, String membershipId, String userId) {
        this.id           = id;
        this.dateFrom     = dateFrom;
        this.dateTo       = dateTo;
        this.membershipId = membershipId;
        this.userId       = userId;
    }

    public static UserMembershipResponse fromAggregate(UserMembership userMembership) {
        return new UserMembershipResponse(
            userMembership.id().value(),
            userMembership.dateFrom(),
            userMembership.dateFrom(),
            userMembership.membershipId().value(),
            userMembership.userId().value()
        );
    }

    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> response = new HashMap<>();

        response.put("id", this.id);
        response.put("date_from", this.dateFrom.toString());
        response.put("date_to", this.dateTo.toString());
        response.put("membership_id", this.membershipId);
        response.put("user_id", this.userId);

        return response;
    }

    public String id() {
        return this.id;
    }

    public LocalDate dateFrom() {
        return this.dateFrom;
    }

    public LocalDate dateTo() {
        return this.dateTo;
    }

    public String membershipId() {
        return this.membershipId;
    }

    public String userId() {
        return this.userId;
    }
}
