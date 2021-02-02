package ar.franciscoruiz.accounts.users;

import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.users.UserId;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public abstract class UsersModuleUnitTestCase extends UnitTestCase {
    protected UserRepository repository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(UserRepository.class);

    }

    public void mockRepositorySearch(User entity) {
        Mockito.when(repository.search(new UserId(entity.id()))).thenReturn(Optional.of(entity));
    }
}
