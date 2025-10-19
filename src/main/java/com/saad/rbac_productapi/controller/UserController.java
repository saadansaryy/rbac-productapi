package com.saad.rbac_productapi.controller;

import com.saad.rbac_productapi.request.UserRequest;
import com.saad.rbac_productapi.serviceImplementation.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        return userServiceImpl.createUser(userRequest);
    }
}
