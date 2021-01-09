package ar.franciscoruiz.workouts.workout_users.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface WorkoutUserRepository {
    void save(WorkoutUser workoutUser);

    Optional<WorkoutUser> search(WorkoutUserId id);

    List<WorkoutUser> matching(Criteria criteria);
}

