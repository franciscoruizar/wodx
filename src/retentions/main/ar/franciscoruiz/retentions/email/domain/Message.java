package ar.franciscoruiz.retentions.email.domain;

public final class Message {
    private final MessageTo   to;
    private final MessageBody body;

    public Message(MessageTo to, MessageBody body) {
        this.to   = to;
        this.body = body;
    }

    public MessageTo getTo() {
        return to;
    }

    public MessageBody getBody() {
        return body;
    }
}
