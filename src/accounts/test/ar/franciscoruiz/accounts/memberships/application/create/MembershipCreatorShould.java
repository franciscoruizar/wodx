package ar.franciscoruiz.accounts.memberships.application.create;

import ar.franciscoruiz.accounts.memberships.MembershipsModuleUnitTestCase;
import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipDomainCreator;
import ar.franciscoruiz.accounts.memberships.domain.MembershipMother;
import org.junit.jupiter.api.Test;

class MembershipCreatorShould extends MembershipsModuleUnitTestCase {
    @Test
    void create_a_valid_membership() {
        MembershipCreator creator = new MembershipCreator(new MembershipDomainCreator(repository));

        Membership membership = MembershipMother.random();

        super.mockRepositorySearch(membership);

        creator.create(membership.id(), membership.description(), membership.numberDaysEnabled(), membership.price(), membership.companyId(), membership.isActive());

        shouldSave(membership);
        shouldHaveSaved(membership);
    }
}
