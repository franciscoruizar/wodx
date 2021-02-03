package ar.franciscoruiz.workouts.step_types.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.step_types.domain.StepType;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlStepTypeRepository extends HibernateRepository<StepType> implements StepTypeRepository {
    public MySqlStepTypeRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, StepType.class, "workouts");
    }

    @Override
    public void save(StepType entity) {
        persist(entity);
    }

    @Override
    public Optional<StepType> search(StepTypeId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id.value()));
    }

    @Override
    public List<StepType> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
