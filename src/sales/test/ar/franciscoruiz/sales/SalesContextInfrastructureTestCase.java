package ar.franciscoruiz.sales;

import ar.franciscoruiz.apps.sales.backend.SalesBackendApplication;
import ar.franciscoruiz.shared.infrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = SalesBackendApplication.class)
@SpringBootTest
public abstract class SalesContextInfrastructureTestCase extends InfrastructureTestCase {
}
