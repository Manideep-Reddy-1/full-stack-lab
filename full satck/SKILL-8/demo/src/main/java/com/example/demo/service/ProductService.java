package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> findByPriceBetween(double min, double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    public List<Product> findAllSortedByPrice() {
        return productRepository.findAllSortedByPrice();
    }

    public List<Product> findExpensiveProducts(double price) {
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() > price)
                .toList();
    }
}
