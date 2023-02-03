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

    public ResponseEntity<String> deleteProduct(String name) {
        try {
            productRepository.findByName(name);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Product not found with name: " + name, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> updateProduct(String name, Product product) {
        Product existingProduct = productRepository.findByName(name);
        if (existingProduct == null) {
            throw new ResourceNotFoundException("Product not found with name: " + name);
        }
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }


}
