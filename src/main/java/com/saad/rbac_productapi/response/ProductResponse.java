package com.saad.rbac_productapi.response;

import com.saad.rbac_productapi.entity.Category;
import com.saad.rbac_productapi.entity.Product;
import lombok.Data;

@Data
public class ProductResponse {

    private String name;
    private Category category;
    private double price;

    public ProductResponse(Product product){
        this.name = product.getName();
        this.category = product.getCategoryId();
        this.price = product.getPrice();
    }
}
