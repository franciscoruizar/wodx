package ar.franciscoruiz.retentions.email.domain;

public interface EmailSender {
    void send(Message message);
}
