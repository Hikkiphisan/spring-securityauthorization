package org.example.sptingsecurityauthorizationaaa.service;

import org.example.sptingsecurityauthorizationaaa.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    boolean add(Product product);
    boolean delete(Long id);
    Product update(Long id, Product productDetails);
}