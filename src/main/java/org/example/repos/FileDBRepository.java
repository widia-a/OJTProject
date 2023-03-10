package org.example.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 15:30
Last modified on 15:30
Version 1.0
*/


import org.example.models.fileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileDBRepository extends JpaRepository<fileDB, Long> {
    fileDB findByName(String name);

    Optional<fileDB> findFileByName (String Name);
}
