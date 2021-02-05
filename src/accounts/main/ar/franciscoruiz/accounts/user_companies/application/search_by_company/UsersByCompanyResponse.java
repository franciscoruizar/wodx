package ar.franciscoruiz.accounts.user_companies.application.search_by_company;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class UsersByCompanyResponse implements Response {
    private final List<UserResponse> users;

    public UsersByCompanyResponse(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> users() {
        return users;
    }
}
