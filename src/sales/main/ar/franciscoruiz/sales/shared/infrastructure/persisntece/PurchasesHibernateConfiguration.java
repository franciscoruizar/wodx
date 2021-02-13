package ar.franciscoruiz.sales.shared.infrastructure.persisntece;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

@Service
public class PurchasesHibernateConfiguration {
    private final HibernateConfigurationFactory hibernateConfigurationFactory;
    private final String                        CONTEXT_NAME = "purchases";

    public PurchasesHibernateConfiguration(Logger logger, EnvironmentParameter config) {
        this.hibernateConfigurationFactory = new HibernateConfigurationFactory(logger, config, CONTEXT_NAME);
    }

    @Bean("purchases-session_factory")
    public SessionFactory sessionFactory() {
        return this.hibernateConfigurationFactory.buildSessionFactory();
    }
}
