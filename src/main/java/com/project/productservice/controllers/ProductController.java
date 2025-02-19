package com.project.productservice.controllers;

import com.project.productservice.dtos.CreateFakeStoreProductDto;
import com.project.productservice.dtos.ErrorDto;
import com.project.productservice.dtos.ProductResponseDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.models.Product;
import com.project.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    public ProductController(@Qualifier("ProductDBService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id) throws ProductNotFoundException {

       Product product= productService.getProductById(id);

        ProductResponseDto productResponseDto = ProductResponseDto.fromEntity(product);

        ResponseEntity<ProductResponseDto> responseEntity = new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product : products){
            productResponseDtos.add(ProductResponseDto.fromEntity(product));
        }
        ResponseEntity<List<ProductResponseDto>> responseEntity = new ResponseEntity<>(productResponseDtos, HttpStatus.OK);
        return responseEntity;

    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateFakeStoreProductDto createFakeStoreProductDto){

        Product product = productService.createProduct(
                createFakeStoreProductDto.getName(),
                createFakeStoreProductDto.getDescription(),
                createFakeStoreProductDto.getPrice(),
                createFakeStoreProductDto.getImageUrl(),
                createFakeStoreProductDto.getCategory()
        );
                ResponseEntity<ProductResponseDto> responseEntity = new ResponseEntity<>(ProductResponseDto.fromEntity(product), HttpStatus.CREATED);
        return responseEntity;

    }

//    This class will handle all nullpointer exceptions in this controller
//    @ExceptionHandler(Exception.class)
//    public ErrorDto NUllPointExceptionHandler(){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("Null pointer exception");
//        errorDto.setStatus("failure");
//        return errorDto;
//    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable long id) throws ProductNotFoundException {

        Product product= productService.getProductById(id);

        ProductResponseDto productResponseDto = ProductResponseDto.fromEntity(product);

        ResponseEntity<ProductResponseDto> responseEntity = new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        return responseEntity;

    }

}
