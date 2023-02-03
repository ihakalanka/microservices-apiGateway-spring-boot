package com.example.productmicroservice.repository;

import com.example.productmicroservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    ResponseEntity<HttpStatus> deleteProduct(String name);
}
