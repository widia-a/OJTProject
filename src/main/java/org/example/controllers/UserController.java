package org.example.controllers;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 08:45
Last modified on 08:45
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.handler.ResponseHandler;
import org.example.message.ResponseMessage;
import org.example.models.Users;
import org.example.services.UserService;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Getter
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("accounts")
    public ResponseEntity<Object>
    saveAccount(@RequestBody Users users,
                @RequestHeader Map<String,String> headers,
                @RequestParam Map<String,String> params,
                WebRequest request, Error error) throws Exception{
        if (users==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        userService.saveUsers(users);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED, users, null, null);
    }

    @PostMapping("accounts/bat")
    public ResponseEntity<Object>
    saveAllAccounts(@RequestBody List<Users> users,
                    @RequestHeader Map<String,String> headers,
                    @RequestParam Map<String,String> params,
                    WebRequest request, Error error) throws Exception {

        if(users==null)throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        userService.saveAllUsers(users);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,null);
    }

    @GetMapping("accounts/datas/all")
    public ResponseEntity<Object> findAllAccounts()throws Exception{
        List<Users> lsUsers = userService.findAllUsers();

        if(lsUsers.size()==0)
        {
            throw new ResourceNotFoundException(ConstantMessage.WARNING_DATA_EMPTY);
        }

        return new ResponseHandler().
                generateResponse(ConstantMessage.SUCCESS_FIND_BY,HttpStatus.OK,lsUsers,null,null);
    }

    @PostMapping("accounts/login")
    public ResponseEntity<Object> accountLogin(@Valid @RequestBody Users users) throws Exception{
        if (users==null) throw new ResourceNotFoundException(ConstantMessage.ERROR_NO_CONTENT);
        return new ResponseHandler().generateResponse(ConstantMessage.SUCCESS_LOGIN, HttpStatus.CREATED, userService.loginAccount(users), null, null);
    }

}
