package ar.franciscoruiz.workouts.exercises.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.exercises.domain.Exercise;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseId;
import ar.franciscoruiz.workouts.exercises.domain.ExerciseRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlExerciseRepository extends HibernateRepository<Exercise> implements ExerciseRepository {
    public MySqlExerciseRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, Exercise.class, "workouts");
    }

    @Override
    public Optional<Exercise> search(ExerciseId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id.value()));
    }

    @Override
    public List<Exercise> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public void save(Exercise exercise) {
        persist(exercise);
    }
}
