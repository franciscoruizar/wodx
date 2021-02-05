package ar.franciscoruiz.accounts.user_companies.application.search_by_user;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public class CompaniesByUserResponse implements Response {
    private final List<CompanyResponse> companies;

    public CompaniesByUserResponse(List<CompanyResponse> collect) {
        this.companies = collect;
    }

    public List<CompanyResponse> companies() {
        return companies;
    }
}
