package ar.franciscoruiz.accounts.user_memberships.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class UserMembershipsResponse implements Response {
    private final List<UserMembershipResponse> values;

    public UserMembershipsResponse(List<UserMembershipResponse> values) {
        this.values = values;
    }

    public List<UserMembershipResponse> values() {
        return this.values;
    }
}
