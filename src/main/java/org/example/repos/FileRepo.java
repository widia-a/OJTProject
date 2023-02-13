package org.example.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author wid a.k.a. Widia
Created on 09/02/2023 12:21
Last modified on 12:21
Version 1.0
*/


import org.example.models.Candidates;
import org.example.models.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<Files, Long> {
}
