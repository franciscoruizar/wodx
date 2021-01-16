package ar.franciscoruiz.retentions.mail.domain;

public final class Message {
    private final MessageTo      to;
    private final MessageBody    body;
    private final MessageSubject subject;

    public Message(MessageTo to, MessageBody body, MessageSubject subject) {
        this.to      = to;
        this.body    = body;
        this.subject = subject;
    }

    public MessageTo to() {
        return this.to;
    }

    public MessageBody body() {
        return this.body;
    }

    public MessageSubject subject() {
        return this.subject;
    }
}
