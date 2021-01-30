package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.auth.AuthEmail;
import ar.franciscoruiz.shared.domain.auth.AuthUser;

import java.util.Optional;

public interface AuthRepository {
    Optional<AuthUser> search(AuthEmail username);
}
