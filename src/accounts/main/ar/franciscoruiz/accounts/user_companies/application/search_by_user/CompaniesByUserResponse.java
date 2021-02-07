package ar.franciscoruiz.accounts.user_companies.application.search_by_user;

import ar.franciscoruiz.accounts.companies.application.CompanyResponse;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CompaniesByUserResponse implements Response {
    private final List<CompanyResponse> values;

    public CompaniesByUserResponse(List<CompanyResponse> values) {
        this.values = values;
    }

    public List<CompanyResponse> values() {
        return values;
    }

    public List<HashMap<String, Serializable>> toPrimitives() {
        return this.values
            .stream()
            .map(CompanyResponse::toPrimitives)
            .collect(Collectors.toList());
    }
}
