package com.project.productservice.repositories;

import com.project.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product save(Product product);
    public Product deleteById(long id);
}
