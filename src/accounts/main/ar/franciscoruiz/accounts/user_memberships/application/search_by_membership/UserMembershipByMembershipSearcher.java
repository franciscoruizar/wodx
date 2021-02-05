package ar.franciscoruiz.accounts.user_memberships.application.search_by_membership;

import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipResponse;
import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class UserMembershipByMembershipSearcher {
    private final UserMembershipRepository repository;

    public UserMembershipByMembershipSearcher(UserMembershipRepository repository) {
        this.repository = repository;
    }

    public UserMembershipsResponse search(MembershipId membershipId) {
        return new UserMembershipsResponse(
            this.repository
                .searchByMembership(membershipId)
                .stream()
                .map(UserMembershipResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
