package ar.franciscoruiz.accounts.memberships;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.memberships.domain.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MembershipsModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected MembershipRepository repository;
}
