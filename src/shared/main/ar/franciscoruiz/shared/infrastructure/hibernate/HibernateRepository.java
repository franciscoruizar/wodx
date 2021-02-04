package ar.franciscoruiz.shared.infrastructure.hibernate;

import ar.franciscoruiz.shared.domain.Identifier;
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

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory    = sessionFactory;
        this.aggregateClass    = aggregateClass;
        this.criteriaConverter = new HibernateCriteriaConverter<>(sessionFactory.getCriteriaBuilder());
    }

    protected void persist(T entity) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(entity);
        session.flush();
        session.clear();
        session.close();
    }

    protected Optional<T> byId(Serializable id) {
        Session session = sessionFactory.openSession();
        try {
            return Optional.ofNullable(session.byId(aggregateClass).load(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return Optional.empty();
    }

    protected List<T> byCriteria(Criteria criteria) {
        Session session = sessionFactory.openSession();
        try{
            CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);

            return session.createQuery(hibernateCriteria).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return Collections.emptyList();
    }

    protected List<T> all() {
        Session session = sessionFactory.openSession();
        try{
            CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);

            criteria.from(aggregateClass);

            return session.createQuery(criteria).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return Collections.emptyList();

    }
}
