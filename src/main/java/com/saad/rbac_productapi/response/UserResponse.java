package com.saad.rbac_productapi.response;

import com.saad.rbac_productapi.entity.User;
import lombok.Data;

@Data
public class UserResponse {
    private long id;
    private String username;
    private String email;

    public UserResponse(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}

