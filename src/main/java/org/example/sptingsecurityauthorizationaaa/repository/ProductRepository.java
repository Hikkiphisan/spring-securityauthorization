package org.example.sptingsecurityauthorizationaaa.repository;

import org.example.sptingsecurityauthorizationaaa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}