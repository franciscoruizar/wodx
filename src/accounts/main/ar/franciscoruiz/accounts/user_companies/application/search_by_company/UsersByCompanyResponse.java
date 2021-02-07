package ar.franciscoruiz.accounts.user_companies.application.search_by_company;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class UsersByCompanyResponse implements Response {
    private final List<UserResponse> values;

    public UsersByCompanyResponse(List<UserResponse> values) {
        this.values = values;
    }

    public List<UserResponse> values() {
        return values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(UserResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
