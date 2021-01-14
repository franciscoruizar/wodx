package ar.franciscoruiz.accounts.user_companies.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class UserCompaniesResponse implements Response {
    private final List<UserCompanyResponse> values;

    public UserCompaniesResponse(List<UserCompanyResponse> values) {
        this.values = values;
    }

    public List<UserCompanyResponse> values() {
        return this.values;
    }
}
