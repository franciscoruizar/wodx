package ar.franciscoruiz.apps.sales.backend;

import ar.franciscoruiz.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"ar.franciscoruiz.shared", "ar.franciscoruiz.sales", "ar.franciscoruiz.apps.shared", "ar.franciscoruiz.apps.sales.backend", "ar.franciscoruiz.authentications"}
)
public class SalesBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {
        };
    }
}
