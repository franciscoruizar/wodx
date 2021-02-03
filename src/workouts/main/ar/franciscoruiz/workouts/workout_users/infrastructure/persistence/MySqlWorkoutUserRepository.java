package ar.franciscoruiz.workouts.workout_users.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.steps.domain.Step;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUser;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserId;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlWorkoutUserRepository extends HibernateRepository<WorkoutUser> implements WorkoutUserRepository {
    public MySqlWorkoutUserRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, WorkoutUser.class, "workouts");
    }

    @Override
    public Optional<WorkoutUser> search(WorkoutUserId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id.value()));
    }

    @Override
    public List<WorkoutUser> matching(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public void save(WorkoutUser workoutUser) {
        persist(workoutUser);
    }
}
