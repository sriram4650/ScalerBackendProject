package com.scaler.productservice.service;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface productservice{

     Product getsingleproduct(Long productid) throws ProductNotFoundException;

    List<Product> getallproducts();

    Product updateProduct(long id,Product product);

    Product updateProduct(Long id, Product product);

    Product replaceProduct(long id, Product product);


    void deleteProduct(long id);



    Product addNewProduct(Product product);
}
