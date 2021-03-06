package ar.franciscoruiz.accounts.companies.domain;

import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.companies.CompanyId;

public final class CompanyNotExist extends DomainError {
    public CompanyNotExist(CompanyId id) {
        super("company_not_exist", String.format("The company <%s> doesn't exist", id.value()));
    }
}
