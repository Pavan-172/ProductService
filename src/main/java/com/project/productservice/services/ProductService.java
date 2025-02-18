package com.project.productservice.services;

import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product createProduct(
            String name, String description, double price,String imageUrl , String category
    );
}
