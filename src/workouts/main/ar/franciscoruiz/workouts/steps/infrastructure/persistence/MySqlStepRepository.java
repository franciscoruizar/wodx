package ar.franciscoruiz.workouts.steps.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.steps.domain.Step;
import ar.franciscoruiz.workouts.steps.domain.StepId;
import ar.franciscoruiz.workouts.steps.domain.StepRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlStepRepository extends HibernateRepository<Step> implements StepRepository {
    public MySqlStepRepository(@Qualifier("workouts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Step.class);
    }

    @Override
    public Optional<Step> search(StepId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id.value()));
    }

    @Override
    public List<Step> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public void save(Step step) {
        persist(step);
    }
}
