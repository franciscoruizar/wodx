package ar.franciscoruiz.shared.infrastructure.spring;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public final class SpringBycriptPasswordEncoder implements PasswordEncoder {

    @Autowired
    private final BCryptPasswordEncoder encoder;

    public SpringBycriptPasswordEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return this.encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.encoder.matches(rawPassword, encodedPassword);
    }
}
