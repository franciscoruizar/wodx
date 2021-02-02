package ar.franciscoruiz.accounts.companies.application.find;

import ar.franciscoruiz.accounts.companies.CompaniesModuleUnitTestCase;
import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyMother;
import org.junit.jupiter.api.Test;

final class CompanyFinderShould extends CompaniesModuleUnitTestCase {
    @Test
    void find_a_valid_company() {
        CompanyFinder finder = new CompanyFinder(repository);

        Company company = CompanyMother.random();

        super.mockRepositorySearch(company);

        finder.find(company.id());
    }
}
