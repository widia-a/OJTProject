package org.example.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author wdi a.k.a. Widia
Created on 15/02/2023 13:46
Last modified on 13:46
Version 1.0
*/


import org.example.models.Konsumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonsumenRepo extends JpaRepository<Konsumen, Long> {
}
