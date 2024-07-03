package com.scaler.productservice.controller;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.service.productservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private productservice Productservice;

    public ProductController(productservice Productservice){
        this.Productservice = Productservice;
    }
    @GetMapping("/{id}")
    public Product getproductbyid(@PathVariable("id") long id){
        return Productservice.getsingleproduct(id);
    }
    @GetMapping()
    public List<Product> getallproducts(){
        return Productservice.getallproducts();
    }
}
