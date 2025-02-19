package com.project.productservice.services;

import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ProductDBService")
public class ProductDBService implements ProductService {
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) throws ProductNotFoundException {
        return null;
    }
}
