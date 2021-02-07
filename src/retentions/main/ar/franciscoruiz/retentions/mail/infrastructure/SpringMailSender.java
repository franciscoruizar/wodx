package ar.franciscoruiz.retentions.mail.infrastructure;

import ar.franciscoruiz.retentions.mail.domain.MailSender;
import ar.franciscoruiz.retentions.mail.domain.Message;
import ar.franciscoruiz.shared.domain.Logger;
import ar.franciscoruiz.shared.domain.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public final class SpringMailSender implements MailSender {
    private final JavaMailSender sender;
    private final Logger logger;

    public SpringMailSender(JavaMailSender sender, Logger logger) {
        this.sender = sender;
        this.logger = logger;
    }

    @Override
    public void send(Message message) {
        MimeMessage       mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper      = new MimeMessageHelper(mimeMessage);

        try{
            helper.setTo(message.to().value());
            helper.setText(message.body().value());
            helper.setSubject(message.subject().value());
            sender.send(mimeMessage);
        }catch (MessagingException e){
            logger.critical(e.getMessage());
        }
    }
}
