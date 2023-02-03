package com.example.productmicroservice.service;

import com.example.productmicroservice.entity.Product;
import com.example.productmicroservice.message.ResourceNotFoundException;
import com.example.productmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findByName(String name) {
        Product product = productRepository.findByName(name);
        if (product == null) {
            throw new ResourceNotFoundException("Product not found with name: " + name);
        }
        return product;
    }




}
