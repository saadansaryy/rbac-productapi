package com.saad.rbac_productapi.service;

import com.saad.rbac_productapi.request.UserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> getAllUsers();

    ResponseEntity<?> createUser(UserRequest userRequest);
}
