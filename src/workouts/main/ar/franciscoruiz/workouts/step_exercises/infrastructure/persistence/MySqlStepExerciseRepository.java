package ar.franciscoruiz.workouts.step_exercises.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExercise;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseId;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlStepExerciseRepository extends HibernateRepository<StepExercise> implements StepExerciseRepository {
    public MySqlStepExerciseRepository(@Qualifier("workouts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, StepExercise.class);
    }

    @Override
    public Optional<StepExercise> search(StepExerciseId id) {
        return byId(id);
    }

    @Override
    public List<StepExercise> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public void save(StepExercise stepExercise) {
        persist(stepExercise);
    }


}
