package com.project.productservice.services;

import com.project.productservice.dtos.FakeProductStoreDto;
import com.project.productservice.dtos.FakeStoreProductRequestDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
//        here we are using dto to convert response json from fakestore api to object , because java works on object
        FakeProductStoreDto fakeProductStoreDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id
                , FakeProductStoreDto.class);

        if(fakeProductStoreDto == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return fakeProductStoreDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {

//         During runtime List<FakeProductStoreDto> , java will remove generic type because of type erasure , so List will become List.class , instead of List<FakeProductStoreDto>.class
        FakeProductStoreDto[] fakeProductStoreDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeProductStoreDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeProductStoreDto fakeProductStoreDto1 : fakeProductStoreDto) {
            products.add(fakeProductStoreDto1.toProduct());
        }
        return products;

    }
    @Override
    public Product createProduct(
            String name, String description, double price,String imageUrl , String category
    ) {

        FakeStoreProductRequestDto fakeStoreProductRequestDto = new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setTitle(name);
        fakeStoreProductRequestDto.setPrice(price);
        fakeStoreProductRequestDto.setDescription(description);
        fakeStoreProductRequestDto.setImage(imageUrl);
        fakeStoreProductRequestDto.setCategory(category);
        FakeProductStoreDto fakeProductStoreDto = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductRequestDto, FakeProductStoreDto.class);

        return fakeProductStoreDto.toProduct();
    }

}
