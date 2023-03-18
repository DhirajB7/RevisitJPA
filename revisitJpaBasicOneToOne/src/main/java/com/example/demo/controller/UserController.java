package com.example.demo.controller;

import com.example.demo.modal.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserByUserId(@PathVariable("id") Long id){
        return userService.getOneUserById(id);
    }

    @GetMapping("/{id}/address")
    public ResponseEntity<Object> getAddressByUserId(@PathVariable("id") Long id){
        return userService.getOneAddressById(id);
    }

}
