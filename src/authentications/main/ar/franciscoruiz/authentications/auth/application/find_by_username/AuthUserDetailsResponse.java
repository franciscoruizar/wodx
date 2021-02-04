package ar.franciscoruiz.authentications.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class AuthUserDetailsResponse implements Response {
    private final String       email;
    private final String       password;
    private final List<String> authorities;

    public AuthUserDetailsResponse(String email, String password, List<String> authorities) {
        this.email       = email;
        this.password    = password;
        this.authorities = authorities;
    }

    public String email() {
        return this.email;
    }

    public String password() {
        return this.password;
    }

    public List<String> authorities() {
        return this.authorities;
    }
}
