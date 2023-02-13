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
import org.example.repos.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidates> findAllCandidates() {
        return candidateRepository.findAll();
    }

}
