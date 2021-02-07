package ar.franciscoruiz.authentications.users;

import ar.franciscoruiz.authentications.AuthenticationsContextInfrastructureTestCase;
import ar.franciscoruiz.authentications.users.domain.AuthenticationsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AuthenticationsUsersModuleInfrastructureTestCase extends AuthenticationsContextInfrastructureTestCase {
    @Autowired
    protected AuthenticationsUserRepository repository;
}
