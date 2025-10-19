package com.saad.rbac_productapi.service;

import com.saad.rbac_productapi.request.ProductRequest;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getAllProducts();

    ResponseEntity<?> createProduct(ProductRequest productRequest);

    ResponseEntity<?> updateProduct(ProductRequest productRequest, long id);

    ResponseEntity<?> deleteProduct(long id);
}
