package io.tulliocba.springbootdownloaduploadfile.properties_binding_config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
public class FilePropertyBinding {

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }
}
