package com.saad.rbac_productapi.serviceImplementation;

import com.saad.rbac_productapi.entity.Product;
import com.saad.rbac_productapi.repository.CategoryRepository;
import com.saad.rbac_productapi.repository.ProductRepository;
import com.saad.rbac_productapi.request.ProductRequest;
import com.saad.rbac_productapi.response.ProductResponse;
import com.saad.rbac_productapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<?> getAllProducts() {
        List<Product> productList = productRepository.findAll();

        List<ProductResponse> productResponseList = productList.stream().map(ProductResponse::new).toList();
        return ResponseEntity.ok(productResponseList);
    }

    @Override
    public ResponseEntity<?> createProduct(ProductRequest productRequest) {
        Product product = new Product();

        product.setName(productRequest.getName());
        product.setCategoryId(categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category NOT FOUND")));
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        Product savedProduct = productRepository.save(product);

        ProductResponse productResponse = new ProductResponse(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
           "message","Product created successfully",
           "body", productResponse,
                "success",true
        ));
    }

    @Override
    public ResponseEntity<?> updateProduct(ProductRequest productRequest, long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product NOT FOUND"));

        product.setName(productRequest.getName());
        product.setCategoryId(categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category NOT FOUND")));
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        Product savedProduct = productRepository.save(product);

        ProductResponse productResponse = new ProductResponse(savedProduct);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "message","Product updated successfully",
                "body", productResponse,
                "success",true
        ));
    }

    @Override
    public ResponseEntity<?> deleteProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product NOT FOUND"));

        productRepository.delete(product);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of(
                "message","Product deleted successfully",
                "success",true
        ));
    }
}
