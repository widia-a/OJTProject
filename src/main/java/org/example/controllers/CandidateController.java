package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 02/02/2023 09:00
Last modified on 09:00
Version 1.0
*/


import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.models.Candidates;
import org.example.repos.CandidateRepository;
import org.example.services.CandidateService;
import org.example.utils.ConstantMessage;
import org.example.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("api/v1/")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateRepository candidateRepo;
//
//    @PostMapping("candidate/upload_multiple")
//    public String handleFormSubmit(Candidates candidates,
//                                   @RequestParam("profilePictureFile") MultipartFile multipartFile1,
//                                   @RequestParam("photoIdFile") MultipartFile multipartFile2,
//                                   @RequestParam("documentFile") MultipartFile multipartFile3) throws IOException {
//
//        String profilePictureFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
//        String photoIdFileName = StringUtils.cleanPath(multipartFile2.getOriginalFilename());
//        String documentFileName = StringUtils.cleanPath(multipartFile3.getOriginalFilename());
//
//        candidates.setProfilePicture(profilePictureFileName);
//        candidates.setPhotoId(photoIdFileName);
//        candidates.setDocument(documentFileName);
//
//        Candidates savedCandidate = candidateRepo.save(candidates);
//        String uploadDir = "candidates/" + savedCandidate.getId();
//
//        FileUploadUtil.saveFile(uploadDir, profilePictureFileName, multipartFile1);
//        FileUploadUtil.saveFile(uploadDir, photoIdFileName, multipartFile2);
//        FileUploadUtil.saveFile(uploadDir, documentFileName, multipartFile3);
//
//        return "message";
//    }

    @GetMapping("candidates/all")
    public ResponseEntity<Object> findAllCandidates() throws Exception {
        List<Candidates> lsCandidates = candidateService.findAllCandidates();

        if (lsCandidates.size() == 0) {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY, HttpStatus.OK, lsCandidates, null, null);
    }

    @PostMapping("coba/upload")
    public ResponseEntity<Object> coba(@RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("profilePictureFile") MultipartFile multipartFile1,
                                       @RequestParam("photoIdFile") MultipartFile multipartFile2,
                                       @RequestParam("documentFile") MultipartFile multipartFile3) throws Exception {

        candidateService.save(firstName, lastName, multipartFile1, multipartFile2, multipartFile3);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, null, null, null);
    }
}
