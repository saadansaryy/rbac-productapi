package com.saad.rbac_productapi.controller;

import com.saad.rbac_productapi.entity.Category;
import com.saad.rbac_productapi.serviceImplementation.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl){
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategories(){
        return categoryServiceImpl.getAllCategories();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody Category categoryRequest){
        return categoryServiceImpl.createCategory(categoryRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category categoryRequest, @PathVariable long id){
        return categoryServiceImpl.updateCategory(categoryRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id){
        return categoryServiceImpl.deleteCategory(id);
    }
}
