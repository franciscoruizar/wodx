package ar.franciscoruiz.authentications.shared.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

@Service
public class AuthenticationsHibernateConfiguration {
    private final HibernateConfigurationFactory hibernateConfigurationFactory;
    private final String                        CONTEXT_NAME = "authentications";

    public AuthenticationsHibernateConfiguration(Logger logger, EnvironmentParameter config) {
        this.hibernateConfigurationFactory = new HibernateConfigurationFactory(logger, config, CONTEXT_NAME);
    }

    @Bean("authentications-session_factory")
    public SessionFactory sessionFactory() {
        return this.hibernateConfigurationFactory.buildSessionFactory();
    }
}
