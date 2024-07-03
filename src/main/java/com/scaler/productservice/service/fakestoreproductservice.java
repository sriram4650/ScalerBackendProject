package com.scaler.productservice.service;

import com.scaler.productservice.dtos.FakeStoreProductdto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class fakestoreproductservice implements productservice{

    private RestTemplate restTemplate;

    public fakestoreproductservice (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getsingleproduct(Long id) {
           FakeStoreProductdto fakestoredto = restTemplate.getForObject(
          "https://fakestoreapi.com/products/"+id, FakeStoreProductdto.class
            );


        return convertFakestoreproducttoProduct(fakestoredto);
    }

    @Override
    public List<Product> getallproducts() {
        FakeStoreProductdto[] fakeStoreProductdtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                FakeStoreProductdto[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductdto fakeStoreProductdto : fakeStoreProductdtos){
            products.add(convertFakestoreproducttoProduct(fakeStoreProductdto));
        }
        return products;
    }

    private Product convertFakestoreproducttoProduct(FakeStoreProductdto fakestoredto){
        Product product = new Product();
        product.setId(fakestoredto.getId());
        product.setTitle(fakestoredto.getTitle());
        product.setPrice(fakestoredto.getPrice());
        Category category = new Category();
        category.setDescription(fakestoredto.getDescription());
        product.setCategory(category);
        return product;

    }
}
