package ar.franciscoruiz.shared.domain.media;

public final class FailedUpload extends Exception {
    public FailedUpload() {
    }

    public FailedUpload(String message) {
        super(message);
    }

    public FailedUpload(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedUpload(Throwable cause) {
        super(cause);
    }

    public FailedUpload(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
