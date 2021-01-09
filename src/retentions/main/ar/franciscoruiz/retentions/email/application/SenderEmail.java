package ar.franciscoruiz.retentions.email.application;

import ar.franciscoruiz.retentions.email.domain.EmailSender;
import ar.franciscoruiz.retentions.email.domain.Message;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class SenderEmail {
    private final EmailSender sender;

    public SenderEmail(EmailSender sender) {
        this.sender = sender;
    }

    public void send(Message message) {
        this.sender.send(message);
    }
}
