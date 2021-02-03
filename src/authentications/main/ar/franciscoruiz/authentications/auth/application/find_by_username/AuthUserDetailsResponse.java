package ar.franciscoruiz.authentications.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class AuthUserDetailsResponse implements Response {
    private final String       username;
    private final String       password;
    private final List<String> authorities;

    public AuthUserDetailsResponse(String username, String password, List<String> authorities) {
        this.username    = username;
        this.password    = password;
        this.authorities = authorities;
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }

    public List<String> authorities() {
        return this.authorities;
    }
}
