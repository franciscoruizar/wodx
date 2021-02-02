package ar.franciscoruiz.apps.shared.middleware;

import ar.franciscoruiz.accounts.auth.application.find_by_username.FindUserByUsernameQuery;
import ar.franciscoruiz.accounts.auth.application.find_by_username.UserDetailsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringSecurityAuthMiddleware implements UserDetailsService {

    private final QueryBus bus;

    public SpringSecurityAuthMiddleware(QueryBus bus) {
        this.bus = bus;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsResponse user = this.bus.ask(new FindUserByUsernameQuery(username));

        if (user == null || user.authorities().isEmpty()) {
            throw new UsernameNotFoundException(String.format("the %s username not found", username));
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for (var role : user.authorities()) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return new User(user.username(), user.password(), roles);
    }
}
