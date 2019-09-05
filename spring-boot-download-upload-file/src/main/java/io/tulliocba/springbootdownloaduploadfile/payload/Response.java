package io.tulliocba.springbootdownloaduploadfile.payload;

import lombok.Data;

@Data
public class Response {

    private final String fileName;
    private final String fileDownloadUri;
    private final String contentType;
    private final long size;

    public Response(String fileName, String fileDownloadUri, String contentType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.contentType = contentType;
        this.size = size;
    }
}
