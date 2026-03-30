package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/category/{category}")
    public List<Product> findByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> findByPriceBetween(
            @RequestParam("min") double min,
            @RequestParam("max") double max) {
        return productService.findByPriceBetween(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> findAllSortedByPrice() {
        return productService.findAllSortedByPrice();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> findExpensiveProducts(@PathVariable double price) {
        return productService.findExpensiveProducts(price);
    }
}
