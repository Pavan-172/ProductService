package com.project.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String description;
    private String imageUrl;
    @ManyToOne
    private Category category;
    private double price;
}
