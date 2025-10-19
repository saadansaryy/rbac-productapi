package com.saad.rbac_productapi.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private long categoryId;
    private double price;
    private int quantity;
}
