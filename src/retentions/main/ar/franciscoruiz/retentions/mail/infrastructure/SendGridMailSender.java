package ar.franciscoruiz.retentions.mail.infrastructure;

import ar.franciscoruiz.retentions.mail.domain.MailSender;
import ar.franciscoruiz.retentions.mail.domain.Message;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.EnvironmentParameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

@Service
public final class SendGridMailSender implements MailSender {
    private final EnvironmentParameter config;

    public SendGridMailSender(EnvironmentParameter config) {
        this.config = config;
    }

    @Override
    public void send(Message message) {

        try {
            Email   from    = new Email("f.ruiz.lezcano@gmail.com");
            String  subject = message.subject().value();
            Email   to      = new Email(message.to().value());
            Content content = new Content("text/html", message.body().value());
            Mail    mail    = new Mail(from, subject, to, content);

            SendGrid sg      = new SendGrid(config.get("SENDGRID_API_KEY"));
            Request  request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        } catch (IOException | ParameterNotExist e) {
            e.printStackTrace();
        }

    }

}
