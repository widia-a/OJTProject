package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 09/02/2023 12:21
Last modified on 12:21
Version 1.0
*/


import org.example.models.Files;
import org.example.repos.FileRepo;
import org.example.services.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("api/v1/")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @Autowired
    private FileRepo fileRepo;

    @PostMapping("dok/file/up")
    public String submitFile(Files files,
                             @RequestParam("files") MultipartFile file
    ) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        files.setName(fileName);

        Files saveFile = fileRepo.save(files);
        return "message";
    }
}
