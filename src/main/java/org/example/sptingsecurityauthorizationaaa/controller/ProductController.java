package org.example.sptingsecurityauthorizationaaa.controller;


import org.example.sptingsecurityauthorizationaaa.model.Product;
import org.example.sptingsecurityauthorizationaaa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /* ---------------- GET ALL PRODUCTS ------------------------ */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /* ---------------- GET PRODUCT BY ID ------------------------ */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }

    /* ---------------- CREATE NEW PRODUCT ------------------------ */
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        if (productService.add(product)) {
            return new ResponseEntity<>("Product Created!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Product Already Exists!", HttpStatus.BAD_REQUEST);
        }
    }

    /* ---------------- DELETE PRODUCT ------------------------ */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (productService.delete(id)) {
            return new ResponseEntity<>("Product Deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product Not Found!", HttpStatus.NOT_FOUND);
        }
    }

    /* ---------------- UPDATE PRODUCT ------------------------ */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.update(id, productDetails);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product Not Found!", HttpStatus.NOT_FOUND);
        }
    }
}
