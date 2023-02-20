package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 15/02/2023 13:45
Last modified on 13:45
Version 1.0
*/

import lombok.Getter;
import org.example.models.Units;
import org.example.repos.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UnitService {
    @Getter
    private UnitRepo unitRepo;

    @Autowired
    public void UnitService(UnitRepo unitRepo){
        this.unitRepo = unitRepo;
    }

    public void saveUnits(Units units) throws Exception {
        unitRepo.save(units);
    }
}
