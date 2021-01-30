package ar.franciscoruiz.accounts.user_memberships.application.create;

import ar.franciscoruiz.accounts.memberships.application.MembershipResponse;
import ar.franciscoruiz.accounts.memberships.application.find.FindMembershipQuery;
import ar.franciscoruiz.accounts.memberships.domain.MembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembership;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipId;
import ar.franciscoruiz.accounts.user_memberships.domain.UserMembershipRepository;
import ar.franciscoruiz.accounts.users.application.find.FindUserQuery;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.users.UserId;

import java.time.LocalDate;

@Service
public final class UserMembershipCreator {
    private final UserMembershipRepository repository;
    private final QueryBus                 queryBus;

    public UserMembershipCreator(UserMembershipRepository repository, QueryBus queryBus) {
        this.repository = repository;
        this.queryBus   = queryBus;
    }

    public void create(UserMembershipId id, LocalDate dateFrom, MembershipId membershipId, UserId userId) {

        ensureUser(userId);

        MembershipResponse membership = getMembership(membershipId);

        LocalDate dateTo = dateFrom.plusDays(membership.numberDaysEnabled());

        UserMembership userMembership = new UserMembership(id.value(), dateFrom, dateTo, membershipId.value(), userId.value());

        this.repository.save(userMembership);
    }

    private MembershipResponse getMembership(MembershipId membershipId) {
        return this.queryBus.ask(new FindMembershipQuery(membershipId.value()));
    }

    private void ensureUser(UserId userId) {
        this.queryBus.ask(new FindUserQuery(userId.value()));
    }
}
