package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 08/02/2023 14:20
Last modified on 14:20
Version 1.0
*/


import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.models.Kontraks;
import org.example.models.Users;
import org.example.models.fileDB;
import org.example.repos.KontrakRepo;
import org.example.repos.UserRepo;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class KontrakService {
    @Getter
    private KontrakRepo kontrakRepo;

    @Autowired
    public void KontrakService(KontrakRepo kontrakRepo){
        this.kontrakRepo = kontrakRepo;
    }

    public void saveKontraks(Kontraks kontraks) throws Exception {
        kontrakRepo.save(kontraks);
    }

    public List<Kontraks> findAllKontraks() {
        return kontrakRepo.findAll();
    }

    public List<Kontraks> findByNoKontrak(String noKontrak) {
        return kontrakRepo.findByNoKontrak(noKontrak);
    }

//    public Kontraks findByNoKontrak(String noKontrak) throws Exception
//    {
//        return kontrakRepo.findByNoKontrak(noKontrak).orElseThrow(()->
//                new ResourceNotFoundException(ConstantMessage.WARNING_NOT_FOUND));
//    }
}
