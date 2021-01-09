package ar.franciscoruiz.apps.retentions.backend;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"ar.franciscoruiz.shared", "ar.franciscoruiz.retentions", "ar.franciscoruiz.apps.retentions.backend"}
)
public class RetentionsBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {{
            put("domain-events:rabbitmq:consume", RabbitMqDomainEventsConsumer.class);
        }};
    }
}
