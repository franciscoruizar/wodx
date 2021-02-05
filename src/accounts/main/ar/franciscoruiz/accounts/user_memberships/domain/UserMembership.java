package ar.franciscoruiz.accounts.user_memberships.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDate;
import java.util.Objects;

public final class UserMembership {
    private final UserMembershipId id;
    private final LocalDate        dateFrom;
    private final LocalDate        dateTo;
    private final MembershipId     membershipId;
    private final UserId           userId;

    public UserMembership(UserMembershipId id, LocalDate dateFrom, LocalDate dateTo, MembershipId membershipId, UserId userId) {
        this.id           = id;
        this.dateFrom     = dateFrom;
        this.dateTo       = dateTo;
        this.membershipId = membershipId;
        this.userId       = userId;
    }

    public UserMembershipId id() {
        return id;
    }

    public LocalDate dateFrom() {
        return dateFrom;
    }

    public LocalDate dateTo() {
        return dateTo;
    }

    public MembershipId membershipId() {
        return membershipId;
    }

    public UserId userId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMembership that = (UserMembership) o;
        return Objects.equals(id, that.id) && Objects.equals(dateFrom, that.dateFrom) && Objects.equals(dateTo, that.dateTo) && Objects.equals(membershipId, that.membershipId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateFrom, dateTo, membershipId, userId);
    }
}
