package ar.franciscoruiz.accounts.user_companies.application;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class UserCompanyResponse implements Response {
    private final String          id;
    private final UserResponse    user;
    private final CompanyResponse company;

    public UserCompanyResponse(String id, UserResponse user, CompanyResponse company) {
        this.id      = id;
        this.user    = user;
        this.company = company;
    }

    public String id() {
        return this.id;
    }

    public UserResponse user() {
        return this.user;
    }

    public CompanyResponse company() {
        return this.company;
    }
}
