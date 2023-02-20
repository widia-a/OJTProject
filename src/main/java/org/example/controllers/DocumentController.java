package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:45
Last modified on 09:45
Version 1.0
*/


import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.models.Documents;
import org.example.repos.DocumentRepo;
import org.example.services.DocumentService;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@RequestMapping("api/v1/")
public class DocumentController {

    @Getter
    private DocumentService documentService;
    private final DocumentRepo documentRepo;

    @Autowired
    public DocumentController(DocumentService documentService, DocumentRepo documentRepo) {
        this.documentService = documentService;
        this.documentRepo = documentRepo;
    }

    @PostMapping("uploadsData")
    public String uploadFile(
            @RequestBody Documents documents,
            @RequestHeader Map<String, String> headers,
            @RequestParam Map<String, String> params,
            @RequestParam("file") MultipartFile file
    ) throws ResourceNotFoundException {
        if (documents == null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        // code to handle file upload
        return "File uploaded successfully!";
}

}
