package ar.franciscoruiz.shared.domain.media;

import java.io.IOException;

public interface MediaUploader {
    String upload(byte[] file) throws IOException, InterruptedException, FailedUpload;
}
