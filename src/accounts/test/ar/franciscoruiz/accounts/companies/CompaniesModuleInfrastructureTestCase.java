package ar.franciscoruiz.accounts.companies;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CompaniesModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected CompanyRepository repository;
}
