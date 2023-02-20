package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 02/02/2023 09:40
Last modified on 09:40
Version 1.0
*/

import org.example.models.Candidates;
import org.example.models.Kontraks;
import org.example.repos.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidates> findAllCandidates() {
        return candidateRepository.findAll();
    }

    public void save(String firstName, String lastName, MultipartFile multipartFile1, MultipartFile multipartFile2, MultipartFile multipartFile3) throws Exception {
        Candidates candidates = new Candidates();
        candidates.setFirstName(firstName);
        candidates.setLastName(lastName);
        candidates.setProfilePicture(multipartFile1.getBytes());
        candidates.setDocument(multipartFile2.getBytes());
        candidates.setPhotoId(multipartFile3.getBytes());
        candidateRepository.save(candidates);
    }


}
