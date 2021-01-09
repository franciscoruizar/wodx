package ar.franciscoruiz.workouts.steps.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface StepRepository {
    void save(Step step);

    Optional<Step> search(StepId id);

    List<Step> matching(Criteria criteria);
}

