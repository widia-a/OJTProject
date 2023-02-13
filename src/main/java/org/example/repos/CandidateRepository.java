package org.example.repos;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 02/02/2023 09:01
Last modified on 09:01
Version 1.0
*/


import org.example.models.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidates, Long> {
}
