package ar.franciscoruiz.workouts.step_exercises.infrastructure.persistence;

import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import ar.franciscoruiz.workouts.exercises.domain.Exercise;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExercise;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseId;
import ar.franciscoruiz.workouts.step_exercises.domain.StepExerciseRepository;

import java.util.List;
import java.util.Optional;

@Service
public final class MySqlStepExerciseRepository extends HibernateRepository<StepExercise> implements StepExerciseRepository {
    public MySqlStepExerciseRepository(Logger logger, EnvironmentParameter environmentParameter) {
        super(logger, environmentParameter, StepExercise.class, "workouts");
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
