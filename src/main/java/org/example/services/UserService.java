package org.example.services;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 08:48
Last modified on 08:48
Version 1.0
*/

import lombok.Getter;
import org.example.handler.ResourceNotFoundException;
import org.example.models.Users;
import org.example.repos.UserRepo;
import org.example.utils.ConstantMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Getter
    private UserRepo userRepo;

    @Autowired
    public void UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public void saveUsers(Users users) throws Exception {
        userRepo.save(users);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveAllUsers(List<Users> ls ) {
        userRepo.saveAll(ls);
    }

    public List<Users> findAllUsers() {
        return userRepo.findAll();
    }

    public Object loginAccount(Users users) throws Exception{
        Users users1 = userRepo.findByNip(users.getNip()).orElseThrow(() ->
                new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL));
        if(users != null){
            if (users1.getPassword().equals(users.getPassword())){
                return users1;
            }
            else{
                throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
            }
        }else{
            throw  new ResourceNotFoundException(ConstantMessage.WARNING_LOGIN_FAIL);
        }
    }

}
