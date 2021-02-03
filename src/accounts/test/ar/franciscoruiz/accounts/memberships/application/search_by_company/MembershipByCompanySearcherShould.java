package ar.franciscoruiz.accounts.memberships.application.search_by_company;

import ar.franciscoruiz.accounts.companies.domain.CompanyId;
import ar.franciscoruiz.accounts.companies.domain.CompanyIdMother;
import ar.franciscoruiz.accounts.memberships.MembershipsModuleUnitTestCase;
import ar.franciscoruiz.accounts.memberships.domain.Membership;
import ar.franciscoruiz.accounts.memberships.domain.MembershipMother;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

final class MembershipByCompanySearcherShould extends MembershipsModuleUnitTestCase {
    @Test
    void search_memberships() {
        MembershipByCompanySearcher searcher = new MembershipByCompanySearcher(repository);

        CompanyId companyId = CompanyIdMother.random();

        List<Membership> membershipsExpected = new ArrayList<>() {{
            add(MembershipMother.random());
            add(MembershipMother.random());
        }};

        super.mockRepositoryFindAll(companyId, membershipsExpected);

        searcher.search(companyId);
    }
}
