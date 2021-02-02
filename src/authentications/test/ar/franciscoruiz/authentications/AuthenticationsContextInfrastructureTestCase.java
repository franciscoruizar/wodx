package ar.franciscoruiz.authentications;

import ar.franciscoruiz.apps.authentications.backend.AuthenticationsBackendApplication;
import ar.franciscoruiz.shared.infrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AuthenticationsBackendApplication.class)
@SpringBootTest
public abstract class AuthenticationsContextInfrastructureTestCase extends InfrastructureTestCase {
}
