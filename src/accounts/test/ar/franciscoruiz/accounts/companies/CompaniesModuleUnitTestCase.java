package ar.franciscoruiz.accounts.companies;

import ar.franciscoruiz.accounts.companies.domain.Company;
import ar.franciscoruiz.accounts.companies.domain.CompanyRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class CompaniesModuleUnitTestCase extends UnitTestCase {
    protected CompanyRepository repository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(CompanyRepository.class);

    }

    public void shouldSave(Company entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Company entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Company entity) {
        Mockito.when(repository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void mockRepositoryFindAll(List<Company> entities) {
        Mockito.when(repository.findAll()).thenReturn(entities);
    }
}
