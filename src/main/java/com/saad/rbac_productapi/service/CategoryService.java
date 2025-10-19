package com.saad.rbac_productapi.service;

import com.saad.rbac_productapi.entity.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<?> getAllCategories();

    ResponseEntity<?> createCategory(Category categoryRequest);

    ResponseEntity<?> updateCategory(Category categoryRequest, long id);

    ResponseEntity<?> deleteCategory(long id);
}
