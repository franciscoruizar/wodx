package ar.franciscoruiz.accounts.memberships;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class MembershipsModuleUnitTestCase extends UnitTestCase {
    protected MembershipRepository repository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(MembershipRepository.class);
    }

    public void shouldSave(Membership entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Membership entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Membership entity) {
        Mockito.when(repository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void mockRepositoryFindAll(CompanyId companyId, List<Membership> entities) {
        Mockito.when(repository.findByCompany(companyId)).thenReturn(entities);
    }
}
