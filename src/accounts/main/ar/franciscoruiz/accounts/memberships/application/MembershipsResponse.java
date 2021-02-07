package ar.franciscoruiz.accounts.memberships.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class MembershipsResponse implements Response {
    private final List<MembershipResponse> values;

    public MembershipsResponse(List<MembershipResponse> values) {
        this.values = values;
    }

    public List<MembershipResponse> values() {
        return this.values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(MembershipResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
