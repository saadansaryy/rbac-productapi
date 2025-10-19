package com.saad.rbac_productapi.serviceImplementation;

import com.saad.rbac_productapi.entity.Category;
import com.saad.rbac_productapi.repository.CategoryRepository;
import com.saad.rbac_productapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @Override
    public ResponseEntity<?> createCategory(Category categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                        "message","Category created successfully",
                        "body",savedCategory,
                        "success",true
                ));
    }

    @Override
    public ResponseEntity<?> updateCategory(Category categoryRequest,long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id : " + id + " NOT FOUND"));

        category.setName(categoryRequest.getName());

        Category savedCategory = categoryRepository.save(category);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "message","Category updated successfully",
                        "body",savedCategory,
                        "success",true
                ));
    }

    @Override
    public ResponseEntity<?> deleteCategory(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id : " + id + " NOT FOUND"));

        categoryRepository.delete(category);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(Map.of(
                        "message","Category deleted successfully",
                        "success",true
                ));
    }
}
