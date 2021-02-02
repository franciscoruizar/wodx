package ar.franciscoruiz.accounts.companies.application.search_all;

import ar.franciscoruiz.accounts.companies.CompaniesModuleUnitTestCase;
import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyMother;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

final class AllCompaniesSearcherShould extends CompaniesModuleUnitTestCase {
    @Test
    void search_all_companies() {
        AllCompaniesSearcher searcher = new AllCompaniesSearcher(repository);

        List<Company> companiesExpected = new ArrayList<>() {{
            add(CompanyMother.random());
            add(CompanyMother.random());
        }};

        super.mockRepositoryFindAll(companiesExpected);

        searcher.search();
    }
}
