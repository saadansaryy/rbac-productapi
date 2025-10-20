package com.saad.rbac_productapi.serviceImplementation;

import com.saad.rbac_productapi.entity.User;
import com.saad.rbac_productapi.repository.UserRepository;
import com.saad.rbac_productapi.request.UserRequest;
import com.saad.rbac_productapi.response.UserResponse;
import com.saad.rbac_productapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<?> getAllUsers(){
        List<User> userList =  userRepository.findAll();
        List<UserResponse> userResponseList = userList.stream().map(UserResponse::new).toList();

        return ResponseEntity.ok(userResponseList);
    }

    @Override
    public ResponseEntity<?> createUser(UserRequest userRequest){
        User user = new User();

        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(userRequest.getRole());

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse(savedUser);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        Map.of(
                                "message","User created successfully",
                                "body",userResponse,
                                "success","true"
                        ));
    }
}
