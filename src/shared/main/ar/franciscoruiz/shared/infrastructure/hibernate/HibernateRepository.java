package ar.franciscoruiz.shared.infrastructure.hibernate;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {
    protected final SessionFactory                sessionFactory;
    protected final Class<T>                      aggregateClass;
    protected final HibernateCriteriaConverter<T> criteriaConverter;
    protected       Logger                        logger;
    protected       EnvironmentParameter          environmentParameter;
    private         Session                       session;

    public HibernateRepository(Logger logger, EnvironmentParameter environmentParameter, Class<T> aggregateClass, String contextName) {
        this.sessionFactory    = new HibernateSessionFactory(logger, environmentParameter, contextName);
        this.aggregateClass    = aggregateClass;
        this.criteriaConverter = new HibernateCriteriaConverter<>(sessionFactory.getCriteriaBuilder());
    }

    public Session session() {
        return session;
    }

    protected void openSession() {
        this.session = sessionFactory.openSession();
        this.session.beginTransaction();
    }

    protected void closeSession() {
        this.session.close();
    }

    protected void persist(T entity) {
        this.openSession();
        this.session().saveOrUpdate(entity);
        this.session().flush();
        this.session().clear();
        this.closeSession();
    }

    protected Optional<T> byId(Serializable id) {
        try {
            this.openSession();
            return Optional.ofNullable(this.session().byId(aggregateClass).load(id));
        } catch (Exception e) {
            logger.critical(e.getMessage());
            e.printStackTrace();
        } finally {
            this.closeSession();
        }

        return Optional.empty();
    }

    protected List<T> byCriteria(Criteria criteria) {


        try {
            this.openSession();

            CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);

            return this.session().createQuery(hibernateCriteria).getResultList();
        } catch (Exception e) {
            logger.critical(e.getMessage());
            e.printStackTrace();
        } finally {
            this.closeSession();
        }

        return Collections.emptyList();
    }

    protected List<T> all() {
        try {
            this.openSession();

            CriteriaQuery<T> criteria = this.session().getCriteriaBuilder().createQuery(this.aggregateClass);

            criteria.from(this.aggregateClass);

            return this.session().createQuery(criteria).getResultList();
        } catch (Exception e) {
            logger.critical(e.getMessage());
            e.printStackTrace();
        } finally {
            this.closeSession();
        }

        return Collections.emptyList();
    }
}
