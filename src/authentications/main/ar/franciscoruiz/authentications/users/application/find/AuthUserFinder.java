package ar.franciscoruiz.authentications.users.application.find;

import ar.franciscoruiz.authentications.users.application.UserResponse;
import ar.franciscoruiz.authentications.users.domain.UserFinderDomain;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class AuthUserFinder {
    private final UserFinderDomain finder;

    public AuthUserFinder(UserFinderDomain finder) {
        this.finder = finder;
    }

    public UserResponse find(UserId id) {
        return UserResponse.fromAggregate(this.finder.find(id));
    }
}
