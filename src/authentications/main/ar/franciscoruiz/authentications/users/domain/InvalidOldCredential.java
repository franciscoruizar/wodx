package ar.franciscoruiz.authentications.users.domain;

public final class InvalidOldCredential extends RuntimeException {
    public InvalidOldCredential(AuthenticationsUserPassword password) {
        super(String.format("The old credential for <%s> are invalid", password.value()));
    }
}
