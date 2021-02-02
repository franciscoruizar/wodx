package ar.franciscoruiz.authentications.shared.infrastructure.persistence;

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
public class AuthenticationsHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final EnvironmentParameter          config;
    private final String                        CONTEXT_NAME = "authentications";

    public AuthenticationsHibernateConfiguration(HibernateConfigurationFactory factory, EnvironmentParameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("authentications-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("authentications-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("authentications-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            CONTEXT_NAME,
            config.get("AUTHENTICATIONS_DATABASE_HOST"),
            config.getInt("AUTHENTICATIONS_DATABASE_PORT"),
            config.get("AUTHENTICATIONS_DATABASE_NAME"),
            config.get("AUTHENTICATIONS_DATABASE_USER"),
            config.get("AUTHENTICATIONS_DATABASE_PASSWORD")
        );
    }
}
