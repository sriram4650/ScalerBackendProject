package com.scaler.productservice.controller;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.service.productservice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private productservice Productservice;

    public ProductController(@Qualifier("selfProductService") productservice Productservice){

        this.Productservice = Productservice;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getproductbyid(@PathVariable("id") long id) throws ProductNotFoundException {
//        ResponseEntity<Product> responseEntity = null;
//       try{
//           Product product = Productservice.getsingleproduct(id);
//           responseEntity=new ResponseEntity<>(
//                   product,
//                   HttpStatus.OK
//           );
//       }
//       catch (RuntimeException e){
//           responseEntity=new ResponseEntity<>(
//                   HttpStatus.BAD_REQUEST
//           );
 //      }

          ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                  Productservice.getsingleproduct(id),
                  HttpStatus.OK
          );

        return responseEntity;
    }
    @GetMapping()
    public List<Product> getallproducts(){
        return Productservice.getallproducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        Productservice.deleteProduct(id);

    }


        @PatchMapping("/{id}")
        public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product){
        return Productservice.updateProduct(id,product);
        }


            @PutMapping("/{id}")
            public Product repalceProduct(@PathVariable("id") long id,@RequestBody Product product){
        return Productservice.replaceProduct(id,product);
            }
//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<String> handleArithmeticException(){
//        ResponseEntity<String> response=new ResponseEntity<>(
//                "something went wrong coming from controller",
//                HttpStatus.NOT_FOUND
//        );
//        return response;
//    }
    @PostMapping
   public Product addNewProduct(@RequestBody Product product){
        return Productservice.addNewProduct(product);
   }

}
