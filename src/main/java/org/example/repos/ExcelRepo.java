package org.example.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author wid a.k.a. Widia
Created on 20/02/2023 09:10
Last modified on 09:10
Version 1.0
*/


import org.example.models.Excels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelRepo extends JpaRepository<Excels, Long> {
}
