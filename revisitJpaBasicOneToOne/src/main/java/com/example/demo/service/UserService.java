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

        if (dataExists(user.getId())) {

            responseData = "Data already Present";

            status = HttpStatus.CONFLICT;

        } else {

            responseData = userRepo.save(user);

            status = HttpStatus.CREATED;

        }

        return new ResponseEntity<>(responseData, status);
    }

    @Override
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getOneAddressById(Long userId) {
        Object responseData;
        HttpStatus status;

        if (dataExists(userId)) {

            responseData = userRepo.findById(userId).get().getAddress();

            status = HttpStatus.OK;

        } else {

            responseData = "USER ID IS NOT VALID";

            status = HttpStatus.NOT_FOUND;

        }

        return new ResponseEntity<>(responseData, status);
    }

    @Override
    public ResponseEntity<Object> getOneUserById(Long userId) {
        Object responseData;
        HttpStatus status;

        if (dataExists(userId)) {

            responseData = userRepo.findById(userId);

            status = HttpStatus.OK;

        } else {

            responseData = "USER ID IS NOT VALID";

            status = HttpStatus.NOT_FOUND;

        }

        return new ResponseEntity<>(responseData, status);
    }

    private boolean dataExists(Long id) {
        return userRepo.findAll().stream().map(a -> a.getId()).collect(Collectors.toList()).contains(id);
    }

}
