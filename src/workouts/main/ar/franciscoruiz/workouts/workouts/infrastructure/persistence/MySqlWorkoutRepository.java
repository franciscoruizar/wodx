package ar.franciscoruiz.workouts.workouts.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.workout_users.domain.WorkoutUser;
import ar.franciscoruiz.workouts.workouts.domain.Workout;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutId;
import ar.franciscoruiz.workouts.workouts.domain.WorkoutRepository;

import java.util.Optional;

@Service
public final class MySqlWorkoutRepository extends HibernateRepository<Workout> implements WorkoutRepository {
    public MySqlWorkoutRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, Workout.class, "workouts");
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
