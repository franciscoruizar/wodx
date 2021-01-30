package ar.franciscoruiz.accounts.memberships.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository {
    void save(Membership membership);

    Optional<Membership> search(MembershipId id);

    List<Membership> matching(Criteria criteria);
}
