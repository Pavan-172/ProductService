package com.project.productservice.models;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
