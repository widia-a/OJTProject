package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:45
Last modified on 09:45
Version 1.0
*/


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/")
public class DocumentController {
    @PostMapping("uploadsFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        // code to handle file upload
        return "File uploaded successfully!";
}

}
