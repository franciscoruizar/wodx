package ar.franciscoruiz.accounts.companies.application;

import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class CompanyResponse implements Response {
    private final String id;
    private final String description;

    public CompanyResponse(String id, String description) {
        this.id          = id;
        this.description = description;
    }

    public static CompanyResponse fromAggregate(Company company){
        return new CompanyResponse(
            company.id().value(),
            company.description().value()
        );
    }

    public String id() {
        return this.id;
    }

    public String description() {
        return this.description;
    }
}
