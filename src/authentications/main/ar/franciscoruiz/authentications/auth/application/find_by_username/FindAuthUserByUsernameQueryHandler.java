package ar.franciscoruiz.authentications.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindAuthUserByUsernameQueryHandler implements QueryHandler<FindAuthUserByUsernameQuery, AuthUserDetailsResponse> {
    private final AuthUserByUsernameFinder authenticator;

    public FindAuthUserByUsernameQueryHandler(AuthUserByUsernameFinder authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public AuthUserDetailsResponse handle(FindAuthUserByUsernameQuery command) {
        AuthEmail email = new AuthEmail(command.email());

        return authenticator.find(email);
    }
}
