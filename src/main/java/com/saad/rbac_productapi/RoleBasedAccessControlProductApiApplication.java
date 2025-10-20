package com.saad.rbac_productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class RoleBasedAccessControlProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedAccessControlProductApiApplication.class, args);
	}
}
