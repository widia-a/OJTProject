package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:47
Last modified on 09:47
Version 1.0
*/


import lombok.Getter;
import org.example.models.Documents;
import org.example.models.Users;
import org.example.repos.DocumentRepo;
import org.example.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentService {
    @Getter
    private DocumentRepo documentRepo;

    @Autowired
    public void DocumentService(DocumentRepo documentRepo){
        this.documentRepo = documentRepo;
    }


    public void saveDocuments(Documents documents) throws Exception {
        documentRepo.save(documents);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllDocuments(List<Documents> ls ) {
        documentRepo.saveAll(ls);
    }

}
