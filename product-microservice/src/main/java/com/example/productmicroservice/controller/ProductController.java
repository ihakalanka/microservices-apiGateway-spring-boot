package com.example.productmicroservice.controller;

import com.example.productmicroservice.entity.Product;
import com.example.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/find/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteProduct(@PathVariable String name) {
        return productService.deleteProduct(name).getBody();
    }





}
