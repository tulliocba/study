package io.tulliocba.springbootdownloaduploadfile.service;

import io.tulliocba.springbootdownloaduploadfile.properties_binding_config.FilePropertyBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FilePropertyBinding filePropertyBinding) {
        this.fileStorageLocation = Paths.get(filePropertyBinding.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            System.out.println("Could not create the directory where the uploaded file will be stored");
        }
    }

    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(fileName.contains("..")) {
            System.out.println("Sorry! The File Name contains invalid path sequence");
            return null;
        }

        Path targetLocation = this.fileStorageLocation.resolve(fileName);

        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            System.out.println("Could not store the file");
        }

        return null;
    }

    public Resource loadFileAsResource(String fileName) {
        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();

        try {
            UrlResource resource = new UrlResource(filePath.toUri());

            if (resource.exists()){
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            System.out.println("File not found");
        }

        return null;
    }
}
