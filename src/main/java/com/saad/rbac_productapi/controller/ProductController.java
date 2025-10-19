package com.saad.rbac_productapi.controller;

import com.saad.rbac_productapi.request.ProductRequest;
import com.saad.rbac_productapi.serviceImplementation.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequest productRequest,@PathVariable long id){
        return productService.updateProduct(productRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }
}
