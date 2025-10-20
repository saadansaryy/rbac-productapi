package com.saad.rbac_productapi.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String role;
}
