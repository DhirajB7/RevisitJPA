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
        System.out.println("===========================");
        System.out.println(user.toString());
        System.out.println("===========================");
        return userService.addUser(user);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        return userService.getAll();
    }

}
