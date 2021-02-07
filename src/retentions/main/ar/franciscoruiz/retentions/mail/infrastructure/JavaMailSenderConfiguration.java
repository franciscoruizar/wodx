package ar.franciscoruiz.retentions.mail.infrastructure;

import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaMailSenderConfiguration {
    private final EnvironmentParameter environmentParameter;

    public JavaMailSenderConfiguration(EnvironmentParameter environmentParameter) {
        this.environmentParameter = environmentParameter;
    }

    @Bean
    public JavaMailSender javaMailSender() throws ParameterNotExist {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environmentParameter.get("RETENTIONS_MAIL_HOST"));
        mailSender.setPort(environmentParameter.getInt("RETENTIONS_MAIL_PORT"));

        mailSender.setUsername(environmentParameter.get("RETENTIONS_MAIL_USERNAME"));
        mailSender.setPassword(environmentParameter.get("RETENTIONS_MAIL_PASSWORD"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
