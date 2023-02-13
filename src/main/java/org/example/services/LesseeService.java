package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:47
Last modified on 09:47
Version 1.0
*/


import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.models.Kontraks;
import org.example.models.Lessees;
import org.example.models.Users;
import org.example.repos.LesseeRepo;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LesseeService {

    @Getter
    private LesseeRepo lesseeRepo;

    @Autowired
    public void LesseeService(LesseeRepo lesseeRepo){
        this.lesseeRepo = lesseeRepo;
    }

    public void saveLessees(Lessees lessees) throws Exception {
        lesseeRepo.save(lessees);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllLessees(List<Lessees> ls ) {
        lesseeRepo.saveAll(ls);
    }

    public List<Lessees> findAllLessees() {
        return lesseeRepo.findAll();
    }

    public Lessees findLesseByNPWP(String npwp) throws Exception
    {
        return lesseeRepo.getLesseeByNPWP(npwp).orElseThrow(()->
                new ResourceNotFoundException(ConstantMessage.WARNING_DATA_NOT_FOUND));
    }

}
