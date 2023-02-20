package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 15/02/2023 13:49
Last modified on 13:49
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.models.Konsumen;
import org.example.models.Units;
import org.example.services.KonsumenService;
import org.example.services.UnitService;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("api/v1/")
public class KonsumenController {
    @Getter
    private KonsumenService konsumenService;

    @Autowired
    public KonsumenController(KonsumenService konsumenService){
        this.konsumenService = konsumenService;
    }

    @PostMapping("/konsumen/add")
    public ResponseEntity<Object>
    saveUnit(@RequestBody Konsumen konsumen,
             @RequestHeader Map<String,String> headers,
             @RequestParam Map<String,String> params,
             WebRequest request, Error error) throws Exception{
        if (konsumen==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        konsumenService.saveKonsumen(konsumen);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, konsumen, null, null);
    }
}
