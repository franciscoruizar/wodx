package ar.franciscoruiz.accounts.user_memberships.domain;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.List;
import java.util.Optional;

public interface UserMembershipRepository {
    void save(UserMembership userMembership);

    Optional<UserMembership> search(UserMembershipId id);

    List<UserMembership> searchByUser(UserId userId);

    List<UserMembership> searchByMembership(MembershipId membershipId);
}
