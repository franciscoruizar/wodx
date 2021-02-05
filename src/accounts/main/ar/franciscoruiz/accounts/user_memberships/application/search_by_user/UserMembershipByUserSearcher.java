package ar.franciscoruiz.accounts.user_memberships.application.search_by_user;

import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipResponse;
import ar.franciscoruiz.accounts.user_memberships.application.UserMembershipsResponse;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.util.stream.Collectors;

@Service
public final class UserMembershipByUserSearcher {
    private final UserMembershipRepository repository;

    public UserMembershipByUserSearcher(UserMembershipRepository repository) {
        this.repository = repository;
    }

    public UserMembershipsResponse search(UserId userId) {
        return new UserMembershipsResponse(
            this.repository
                .searchByUser(userId)
                .stream()
                .map(UserMembershipResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
