package org.example.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author wid a.k.a. Widia
Created on 08/02/2023 14:19
Last modified on 14:19
Version 1.0
*/


import org.example.models.Kontraks;
import org.example.models.Users;
import org.example.models.fileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KontrakRepo  extends JpaRepository<Kontraks, Long> {

//    Optional<Kontraks> findByNoKontrak(String noKontrak);
    List<Kontraks> findByNoKontrak(String noKontrak);

}
