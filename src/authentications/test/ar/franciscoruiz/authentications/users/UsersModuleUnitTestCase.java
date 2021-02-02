package ar.franciscoruiz.authentications.users;

import ar.franciscoruiz.authentications.users.domain.User;
import ar.franciscoruiz.authentications.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class UsersModuleUnitTestCase extends UnitTestCase {
    protected UserRepository repository;
    protected PasswordEncoder encoder;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(UserRepository.class);

        encoder = mock(PasswordEncoder.class);
    }

    public void shouldSave(User entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(User entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositorySearch(User entity) {
        Mockito.when(repository.search(entity.id())).thenReturn(Optional.of(entity));
    }

    public void mockPasswordEncoderEncode(String rawPassword){
        Mockito.when(encoder.encode(rawPassword)).thenReturn(rawPassword);
    }

    public void mockPasswordEncoderMatch(String rawPassword, String encodedPassword){
        Mockito.when(encoder.matches(rawPassword, encodedPassword)).thenReturn(rawPassword.equals(encodedPassword));
    }
}
