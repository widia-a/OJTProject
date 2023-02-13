package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:45
Last modified on 09:45
Version 1.0
*/


import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.models.Lessees;
import org.example.repos.LesseeRepo;
import org.example.services.LesseeService;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class LesseeController {

    @Getter
    private LesseeService lesseeService;

    private final LesseeRepo lesseeRepo;

    @Autowired
    public LesseeController(LesseeService lesseeService, LesseeRepo lesseeRepo){
        this.lesseeService = lesseeService;
        this.lesseeRepo = lesseeRepo;
    }

    @PostMapping("lessee")
    public ResponseEntity<Object>
    saveAccount(@RequestBody Lessees lessees,
                @RequestHeader Map<String,String> headers,
                @RequestParam Map<String,String> params,
                WebRequest request, Error error) throws Exception{
        if (lessees==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        lesseeService.saveLessees(lessees);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, lessees, null, null);
    }

    @PostMapping("lessee/bat")
    public ResponseEntity<Object>
    saveAllAccounts(@RequestBody List<Lessees> lessees,
                    @RequestHeader Map<String,String> headers,
                    @RequestParam Map<String,String> params,
                    WebRequest request, Error error) throws Exception {

        if(lessees==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        lesseeService.saveAllLessees(lessees);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,lessees,null,null);
    }

    @GetMapping("lessee/all")
    public ResponseEntity<Object> findAllLessees()throws Exception{
        List<Lessees> lsUsers = lesseeService.findAllLessees();

        if(lsUsers.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }
        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsUsers,null,null);
    }

    @GetMapping("lessee/no")
    public ResponseEntity<Object> findByNPWP(@RequestParam("npwp") String npwp)throws Exception{

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lesseeService.findLesseByNPWP(npwp),null,null);
    }
}
