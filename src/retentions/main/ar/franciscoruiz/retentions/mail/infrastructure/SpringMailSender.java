package ar.franciscoruiz.retentions.mail.infrastructure;

import ar.franciscoruiz.retentions.mail.domain.MailSender;
import ar.franciscoruiz.retentions.mail.domain.Message;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public final class SpringMailSender implements MailSender {
    private final JavaMailSender javaMailSender;

    public SpringMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(Message message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(message.to().value());
        simpleMailMessage.setSubject(message.subject().value());
        simpleMailMessage.setText(message.body().value());

        javaMailSender.send(simpleMailMessage);
    }
}
