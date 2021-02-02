package ar.franciscoruiz.authentications.auth;

import ar.franciscoruiz.authentications.AuthenticationsContextInfrastructureTestCase;
import ar.franciscoruiz.authentications.auth.domain.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AuthModuleInfrastructureTestCase extends AuthenticationsContextInfrastructureTestCase {
    @Autowired
    protected AuthRepository repository;
}
