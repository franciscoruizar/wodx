package ar.franciscoruiz.retentions.mail.domain;

public interface MailSender {
    void send(Message message);
}
