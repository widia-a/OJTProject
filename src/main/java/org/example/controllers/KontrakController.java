package org.example.controllers;
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
import org.example.handler.ResponseHandler;
import org.example.models.Kontraks;
import org.example.models.Users;
import org.example.models.fileDB;
import org.example.repos.KontrakRepo;
import org.example.services.KontrakService;
import org.example.services.UserService;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class KontrakController {

    @Getter
    private KontrakService kontrakService;
    private final KontrakRepo kontrakRepo;

    @Autowired
    public KontrakController(KontrakService kontrakService,
                             KontrakRepo kontrakRepo){
        this.kontrakService = kontrakService;
        this.kontrakRepo = kontrakRepo;
    }

    @PostMapping("kontrak")
    public ResponseEntity<Object>
    saveAccount(@RequestBody Kontraks kontraks,
                @RequestHeader Map<String,String> headers,
                @RequestParam Map<String,String> params,
                WebRequest request, Error error) throws Exception{
        if (kontraks==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        kontrakService.saveKontraks(kontraks);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, kontraks, null, null);
    }

    @GetMapping("kontrak/datas/all")
    public ResponseEntity<List<Kontraks>> getfindAll() {
        try {
            List<Kontraks> lsCustomers = kontrakService.findAllKontraks();
            if (lsCustomers.isEmpty()) {
                throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
            }
            return new ResponseEntity<>(lsCustomers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}

    @GetMapping("kontrak/byno")
//    public ResponseEntity<Object> findByNoKontrak(@RequestParam("noKontrak") String noKontrak)throws Exception{
//        return new ResponseHandler().
//                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,kontrakService.findByNoKontrak(noKontrak),ConstantMessage.WARNING_NOT_FOUND,null);
//    }
    public ResponseEntity<List<Kontraks>> findByNoKontrak(@RequestParam("noKontrak") String noKontrak) {
                return new ResponseEntity<>(kontrakRepo.findByNoKontrak(noKontrak), HttpStatus.OK);
    }

}
