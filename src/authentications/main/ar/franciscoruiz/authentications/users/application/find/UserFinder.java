package ar.franciscoruiz.authentications.users.application.find;

import ar.franciscoruiz.authentications.users.application.UserResponse;
import ar.franciscoruiz.authentications.users.domain.UserFinderDomain;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.users.UserId;

@Service
public final class UserFinder {
    private final UserFinderDomain finder;

    public UserFinder(UserFinderDomain finder) {
        this.finder = finder;
    }

    public UserResponse find(UserId id) {
        return UserResponse.fromAggregate(this.finder.find(id));
    }
}
