package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 20/02/2023 09:25
Last modified on 09:25
Version 1.0
*/


import lombok.Getter;
import org.example.helper.ExcelHelper;
import org.example.models.Excels;
import org.example.repos.ExcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    @Getter
    private ExcelRepo excelRepo;

    @Autowired
    public ExcelService(ExcelRepo excelRepo){
        this.excelRepo = excelRepo;
    }

    public void save(MultipartFile file) {
        try {
            List<Excels> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            excelRepo.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Excels> getAllTutorials() {
        return excelRepo.findAll();
    }
}
