package ar.franciscoruiz.accounts.user_memberships.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class UserMembershipsResponse implements Response {
    private final List<UserMembershipResponse> values;

    public UserMembershipsResponse(List<UserMembershipResponse> values) {
        this.values = values;
    }

    public List<UserMembershipResponse> values() {
        return this.values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(UserMembershipResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
