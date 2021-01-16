package ar.franciscoruiz.apps.workouts.backend.configs;

import ar.franciscoruiz.apps.shared.middleware.BasicHttpAuthMiddleware;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class WorkoutsBackendServerConfiguration {
    private final        CommandBus bus;

    public WorkoutsBackendServerConfiguration(CommandBus bus) {
        this.bus = bus;
    }

    //@Bean
    public FilterRegistrationBean<BasicHttpAuthMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<BasicHttpAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new BasicHttpAuthMiddleware(bus));
        registrationBean.addUrlPatterns("/exercises");

        return registrationBean;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
            .setAnnotationIntrospector(new JacksonAnnotationIntrospector())
            .registerModule(new JavaTimeModule())
            .setDateFormat(new StdDateFormat())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
