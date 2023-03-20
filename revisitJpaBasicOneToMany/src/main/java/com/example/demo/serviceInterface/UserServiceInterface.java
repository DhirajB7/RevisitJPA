package com.example.demo.serviceInterface;

import com.example.demo.modal.User;
import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {

    ResponseEntity<Object> addUser(User user);

    ResponseEntity<Object> getAll();

}
