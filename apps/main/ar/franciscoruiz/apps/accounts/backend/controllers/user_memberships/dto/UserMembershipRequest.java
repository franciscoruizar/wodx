package ar.franciscoruiz.apps.accounts.backend.controllers.user_memberships.dto;

import java.time.LocalDate;

public final class UserMembershipRequest {
    private String    id;
    private LocalDate dateFrom;
    private String    membershipId;
    private String    userId;

    public UserMembershipRequest(String id, LocalDate dateFrom, String membershipId, String userId) {
        this.id           = id;
        this.dateFrom     = dateFrom;
        this.membershipId = membershipId;
        this.userId       = userId;
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate dateFrom() {
        return this.dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String membershipId() {
        return this.membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String userId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
