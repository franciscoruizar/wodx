package ar.franciscoruiz.workouts.step_types.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface StepTypeRepository {
    void save(StepType entity);

    Optional<StepType> search(StepTypeId id);

    List<StepType> matching(Criteria criteria);
}

