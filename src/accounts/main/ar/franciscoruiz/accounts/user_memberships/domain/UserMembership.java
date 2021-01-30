package ar.franciscoruiz.accounts.user_memberships.domain;

import java.time.LocalDate;

public final class UserMembership {
    private final String    id;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;
    private final String    membershipId;
    private final String    userId;

    public UserMembership(
        String id,
        LocalDate dateFrom,
        LocalDate dateTo,
        String membershipId,
        String userId
    ) {
        this.id           = id;
        this.dateFrom     = dateFrom;
        this.dateTo       = dateTo;
        this.membershipId = membershipId;
        this.userId       = userId;
    }

    public UserMembership() {
        this.id           = null;
        this.dateFrom     = null;
        this.dateTo       = null;
        this.membershipId = null;
        this.userId       = null;
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
