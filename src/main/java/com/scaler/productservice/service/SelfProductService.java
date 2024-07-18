package com.scaler.productservice.service;


import com.scaler.productservice.Repositories.CategoryRepository;
import com.scaler.productservice.Repositories.ProductRepository;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements productservice{

     private ProductRepository productRepository;
     private CategoryRepository categoryRepository;

     public SelfProductService (ProductRepository productRepository,CategoryRepository categoryRepository){
         this.productRepository = productRepository;
         this.categoryRepository= categoryRepository;
     }

     @Override
    public Product getsingleproduct(Long productid) throws ProductNotFoundException {
         Optional<Product> productOptional = productRepository.findById(productid);
        if (productOptional.isEmpty()){
            throw new ProductNotFoundException("product with id not found");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getallproducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId()==null){
            category = categoryRepository.save(category);
            product.setCategory(category);
        }
        return productRepository.save(product);
    }


}



