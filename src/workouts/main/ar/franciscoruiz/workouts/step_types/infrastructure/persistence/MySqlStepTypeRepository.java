package ar.franciscoruiz.workouts.step_types.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.step_types.domain.StepType;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeId;
import ar.franciscoruiz.workouts.step_types.domain.StepTypeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("workouts-transaction_manager")
public final class MySqlStepTypeRepository extends HibernateRepository<StepType> implements StepTypeRepository {
    public MySqlStepTypeRepository(@Qualifier("workouts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, StepType.class);
    }

    @Override
    public Optional<StepType> search(StepTypeId id) {
        return byId(id);
    }
}
