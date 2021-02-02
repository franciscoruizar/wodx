package ar.franciscoruiz.accounts.companies.infrastructure;

import ar.franciscoruiz.accounts.companies.CompaniesModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
class HibernateCompanyRepositoryShould extends CompaniesModuleInfrastructureTestCase {
    @ParameterizedTest
    @MethodSource("getCompanies")
    void create_a_valid_company(Company company) {
        repository.save(company);
    }

    @ParameterizedTest
    @MethodSource("getCompanies")
    void search_a_valid_company(Company company) {
        repository.save(company);

        Assertions.assertEquals(Optional.of(company), repository.search(company.id()));
    }

    @ParameterizedTest
    @MethodSource("getCompanies")
    void search_a_non_valid_company(Company company) {
        Assertions.assertFalse(repository.search(company.id()).isPresent());
    }

    private List<? extends Company> getCompanies() {
        return Arrays.asList(CompanyMother.random(), CompanyMother.random());
    }
}
