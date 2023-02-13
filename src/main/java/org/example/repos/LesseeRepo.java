package org.example.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:44
Last modified on 09:44
Version 1.0
*/


import org.example.models.Lessees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LesseeRepo extends JpaRepository<Lessees, Long> {


    @Query(value = "SELECT * FROM TblLessee WHERE NPWP = :npwp",nativeQuery = true)
    Optional<Lessees> getLesseeByNPWP(@Param("npwp") String npwp);


}
