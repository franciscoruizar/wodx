package ar.franciscoruiz.accounts.companies.application.create;

import ar.franciscoruiz.accounts.companies.CompaniesModuleUnitTestCase;
import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyMother;
import org.junit.jupiter.api.Test;

final class CompanyCreatorShould extends CompaniesModuleUnitTestCase {
    @Test
    void create_a_valid_company() {
        CompanyCreator creator = new CompanyCreator(repository);

        Company company = CompanyMother.random();

        super.mockRepositorySearch(company);

        creator.create(company.id(), company.description(), company.mediaUrl(), company.latitude(), company.longitude(), company.isActive());

        shouldSave(company);
        shouldHaveSaved(company);
    }
}
