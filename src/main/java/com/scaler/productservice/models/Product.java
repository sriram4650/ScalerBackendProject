package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends basemodel{

    private String title;
    private double price;
    private Category category;
}
