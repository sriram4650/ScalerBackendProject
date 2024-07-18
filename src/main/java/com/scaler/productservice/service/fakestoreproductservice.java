package com.scaler.productservice.service;

import com.scaler.productservice.dtos.FakeStoreProductdto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class fakestoreproductservice implements productservice{

    private RestTemplate restTemplate;

    public fakestoreproductservice (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getsingleproduct(Long id) throws ProductNotFoundException {


           FakeStoreProductdto fakestoredto = restTemplate.getForObject(
          "https://fakestoreapi.com/products/"+id, FakeStoreProductdto.class
            );
           if(fakestoredto==null){

               throw new ProductNotFoundException("Product with id" + id + " doesnt exists");
           }


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

    @Override
    public Product updateProduct(long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductdto.class);
        HttpMessageConverterExtractor<FakeStoreProductdto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductdto.class, restTemplate.getMessageConverters());
        FakeStoreProductdto response =  restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PATCH, requestCallback, responseExtractor);
         return convertFakestoreproducttoProduct(response);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductdto.class);
        HttpMessageConverterExtractor<FakeStoreProductdto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductdto.class, restTemplate.getMessageConverters());
        FakeStoreProductdto response =  restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakestoreproducttoProduct(response);
    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
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
