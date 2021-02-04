package ar.franciscoruiz.workouts.shared.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

@Service
public class WorkoutsHibernateConfiguration {
    private final HibernateConfigurationFactory hibernateConfigurationFactory;
    private final String                        CONTEXT_NAME = "workouts";

    public WorkoutsHibernateConfiguration(Logger logger, EnvironmentParameter config) {
        this.hibernateConfigurationFactory = new HibernateConfigurationFactory(logger, config, CONTEXT_NAME);
    }

    @Bean("workouts-session_factory")
    public SessionFactory sessionFactory() {
        return this.hibernateConfigurationFactory.buildSessionFactory();
    }
}
