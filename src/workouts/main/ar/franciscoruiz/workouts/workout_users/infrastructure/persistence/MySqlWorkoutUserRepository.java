package ar.franciscoruiz.workouts.workout_users.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUser;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserId;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("workouts-transaction_manager")
public final class MySqlWorkoutUserRepository extends HibernateRepository<WorkoutUser> implements WorkoutUserRepository {
    public MySqlWorkoutUserRepository(@Qualifier("workouts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, WorkoutUser.class);
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
