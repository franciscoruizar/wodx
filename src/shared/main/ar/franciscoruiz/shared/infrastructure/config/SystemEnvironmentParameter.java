package ar.franciscoruiz.shared.infrastructure.config;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;

@Service
public final class SystemEnvironmentParameter implements EnvironmentParameter {
    @Override
    public String get(String parameter) throws ParameterNotExist {
        String value = System.getenv(parameter);

        if (null == value) {
            throw new ParameterNotExist(parameter);
        }

        return value;
    }

    @Override
    public Integer getInt(String parameter) throws ParameterNotExist {
        return Integer.parseInt(get(parameter));
    }
}
