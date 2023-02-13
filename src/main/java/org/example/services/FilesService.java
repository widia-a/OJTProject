package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 09/02/2023 12:21
Last modified on 12:21
Version 1.0
*/

import org.example.repos.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilesService {

    @Autowired
    private FileRepo fileRepo;

}
