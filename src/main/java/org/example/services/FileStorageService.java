package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 16:06
Last modified on 16:06
Version 1.0
*/


import org.example.handler.ResourceNotFoundException;
import org.example.models.fileDB;
import org.example.repos.FileDBRepository;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileStorageService {
    @Autowired
    private FileDBRepository fileDBRepository;

    public fileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        fileDB FileDB = new fileDB(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(FileDB);
    }

    public fileDB getFile(String name) {

        return fileDBRepository.findByName(name);
    }

    public Stream<fileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
