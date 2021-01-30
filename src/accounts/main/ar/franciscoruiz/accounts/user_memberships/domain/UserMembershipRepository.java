package ar.franciscoruiz.accounts.user_memberships.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface UserMembershipRepository {
    void save(UserMembership userMembership);

    Optional<UserMembership> search(UserMembershipId id);

    List<UserMembership> matching(Criteria criteria);
}
