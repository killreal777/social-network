package org.team.postservice.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void save(String filename, MultipartFile file);

    ByteArrayResource get(String filename);

    void delete(String filename);
}