package ar.franciscoruiz.accounts.memberships.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class MembershipsResponse implements Response {
    private final List<MembershipResponse> values;

    public MembershipsResponse(List<MembershipResponse> values) {
        this.values = values;
    }

    public List<MembershipResponse> values() {
        return this.values;
    }
}
