package ar.franciscoruiz.accounts.user_memberships.application;

import ar.franciscoruiz.accounts.user_memberships.domain.UserMembership;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.time.LocalDate;

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
