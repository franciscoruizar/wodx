package ar.franciscoruiz.workouts.shared.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class WorkoutsHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final EnvironmentParameter          config;
    private final String                        CONTEXT_NAME = "workouts";

    public WorkoutsHibernateConfiguration(HibernateConfigurationFactory factory, EnvironmentParameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("workouts-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("workouts-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("workouts-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("WORKOUTS_DATABASE_HOST"),
            config.getInt("WORKOUTS_DATABASE_PORT"),
            config.get("WORKOUTS_DATABASE_NAME"),
            config.get("WORKOUTS_DATABASE_USER"),
            config.get("WORKOUTS_DATABASE_PASSWORD")
        );
    }
}
