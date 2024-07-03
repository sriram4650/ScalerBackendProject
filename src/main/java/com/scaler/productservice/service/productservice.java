package com.scaler.productservice.service;

import com.scaler.productservice.models.Product;

import java.util.List;

public interface productservice{

    Product getsingleproduct(Long productid);

    List<Product> getallproducts();
}
