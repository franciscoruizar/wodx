package ar.franciscoruiz.retentions.mail.application;

import ar.franciscoruiz.retentions.mail.domain.MailSender;
import ar.franciscoruiz.retentions.mail.domain.Message;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class SenderMail {
    private final MailSender sender;

    public SenderMail(MailSender sender) {
        this.sender = sender;
    }

    public void send(Message message) {
        this.sender.send(message);
    }
}
