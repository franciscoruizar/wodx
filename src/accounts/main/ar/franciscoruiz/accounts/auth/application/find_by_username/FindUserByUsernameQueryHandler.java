package ar.franciscoruiz.accounts.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUserByUsernameQueryHandler implements QueryHandler<FindUserByUsernameQuery, UserDetailsResponse> {
    private final UserByUsernameFinder authenticator;

    public FindUserByUsernameQueryHandler(UserByUsernameFinder authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public UserDetailsResponse handle(FindUserByUsernameQuery command) {
        AuthEmail    email    = new AuthEmail(command.email());

        return authenticator.find(email);
    }
}
