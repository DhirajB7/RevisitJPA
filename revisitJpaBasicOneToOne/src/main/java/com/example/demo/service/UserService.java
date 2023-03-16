package com.example.demo.service;

import com.example.demo.modal.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<Object> addUser(User user) {

        Object responseData;
        HttpStatus status;

        boolean idExist = userRepo.findAll().stream().map(a -> a.getId()).collect(Collectors.toList()).contains(user.getId());

        if(idExist){

            responseData = "Data already Present";

            status = HttpStatus.CONFLICT;

        }else{

            responseData = userRepo.save(user);

            status = HttpStatus.CREATED;

        }

        return new ResponseEntity<>(responseData,status);
    }

    @Override
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }
}
