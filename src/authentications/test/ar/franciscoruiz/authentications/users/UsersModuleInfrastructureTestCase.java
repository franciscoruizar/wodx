package ar.franciscoruiz.authentications.users;

import ar.franciscoruiz.authentications.AuthenticationsContextInfrastructureTestCase;
import ar.franciscoruiz.authentications.users.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UsersModuleInfrastructureTestCase extends AuthenticationsContextInfrastructureTestCase {
    @Autowired
    protected UserRepository repository;
}
