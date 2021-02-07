package ar.franciscoruiz.accounts.companies.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public final class CompaniesResponse implements Response {
    private final List<CompanyResponse> values;

    public CompaniesResponse(List<CompanyResponse> values) {
        this.values = values;
    }

    public List<CompanyResponse> values() {
        return this.values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(CompanyResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
