package ar.franciscoruiz.workouts.workouts.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.workouts.domain.Workout;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("workouts-transaction_manager")
public final class MySqlWorkoutRepository extends HibernateRepository<Workout> implements WorkoutRepository {
    public MySqlWorkoutRepository(@Qualifier("workouts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Workout.class);
    }

    @Override
    public Optional<Workout> search(WorkoutId id) {
        return byId(id);
    }

    @Override
    public void save(Workout workout) {
        persist(workout);
    }
}
