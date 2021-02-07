package ar.franciscoruiz.accounts.users.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class UsersResponse implements Response {
    private final List<UserResponse> values;

    public UsersResponse(List<UserResponse> values) {
        this.values = values;
    }

    public List<UserResponse> values() {
        return this.values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(UserResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
