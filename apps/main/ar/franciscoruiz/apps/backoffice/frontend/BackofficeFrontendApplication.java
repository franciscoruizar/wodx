package ar.franciscoruiz.apps.backoffice.frontend;

import ar.franciscoruiz.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {
        "ar.franciscoruiz.shared",
        "ar.franciscoruiz.accounts",
        "ar.franciscoruiz.analytics",
        "ar.franciscoruiz.retentions",
        "ar.franciscoruiz.apps.shared",
        "ar.franciscoruiz.apps.backoffice.frontend"
    }
)
public class BackofficeFrontendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {
        };
    }
}
