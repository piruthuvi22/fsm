package com.freshkeys.fsm.controller;

import com.freshkeys.fsm.entity.Product;
import com.freshkeys.fsm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;


    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/add-products")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/get-products")
    public List<Product> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/get-product-by-id/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/get-product-by-name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

}
