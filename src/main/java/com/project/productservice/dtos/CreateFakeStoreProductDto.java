package com.project.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFakeStoreProductDto {
    private String name;
    private String description;
    private String imageUrl;
    private String category;
    private double price;
}
