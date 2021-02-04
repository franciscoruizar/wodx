package ar.franciscoruiz.apps.shared.configs;

import ar.franciscoruiz.authentications.auth.application.find_by_username.AuthUserDetailsResponse;
import ar.franciscoruiz.authentications.auth.application.find_by_username.FindAuthUserByEmailQuery;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringSecurityUserDetails implements UserDetailsService {
    private final QueryBus bus;

    public SpringSecurityUserDetails(QueryBus bus) {
        this.bus = bus;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserDetailsResponse user = this.bus.ask(new FindAuthUserByEmailQuery(username));

        if (user == null || user.authorities().isEmpty()) {
            throw new UsernameNotFoundException(String.format("the %s username not found", username));
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        for (var role : user.authorities()) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return new User(user.email(), user.password(), roles);
    }
}
