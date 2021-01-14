package ar.franciscoruiz.accounts.companies.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class CompaniesResponse implements Response {
    private final List<CompanyResponse> values;

    public CompaniesResponse(List<CompanyResponse> values) {
        this.values = values;
    }

    public List<CompanyResponse> values() {
        return this.values;
    }
}
