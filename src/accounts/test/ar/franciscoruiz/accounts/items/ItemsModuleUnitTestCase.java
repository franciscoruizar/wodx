package ar.franciscoruiz.accounts.items;

import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import ar.franciscoruiz.accounts.items.domain.Item;
import ar.franciscoruiz.accounts.items.domain.PurchaseItemRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ItemsModuleUnitTestCase extends UnitTestCase {
    protected PurchaseItemRepository repository;
    protected MembershipRepository   membershipRepository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository           = mock(PurchaseItemRepository.class);
        membershipRepository = mock(MembershipRepository.class);
    }

    public void shouldSave(Item entity) {
        this.repository.save(entity);
    }

    public void shouldMembershipSave(Membership entity) {
        this.membershipRepository.save(entity);
    }

    public void shouldHaveSaved(Item entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void shouldMembershipHaveSaved(Membership entity) {
        verify(membershipRepository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(Item entity) {
        Mockito.when(repository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void mockMembershipRepositorySearch(Membership entity) {
        Mockito.when(membershipRepository.search(entity.id())).thenReturn(Optional.of(entity));
    }
}