package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 16:11
Last modified on 16:11
Version 1.0
*/

import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.message.ResponseFile;
import org.example.message.ResponseMessage;
import org.example.models.fileDB;
import org.example.services.FileStorageService;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/v1/")
public class FileController {
    @Autowired
    private FileStorageService storageService;

    @PostMapping("upfile")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("files") MultipartFile file){
        String message = "";
        try {
            storageService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("filesup")
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                try {
                    storageService.store(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                fileNames.add(file.getOriginalFilename());
            });

            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("listfiles")
    public ResponseEntity<Object> getListFiles() throws Exception {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("api/v1/filesby/")
                    .path(dbFile.getName())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

//        return ResponseEntity.status(HttpStatus.OK).body(files);

        if(files.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,files,null,null);
    }

    @GetMapping("filesby/{name}")
    public ResponseEntity<byte[]> getFile(@PathVariable String name) throws Exception {
        fileDB filesDB = storageService.getFile(name);
        System.out.println(filesDB.getName());

        File file = new File(filesDB.getName());

        fileDB files = storageService.downloadImage(name);

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(files.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filesDB.getName() + "\"") //preview in web
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filesDB.getName() + "\"") //download file
                .body(filesDB.getData());


    }
}

