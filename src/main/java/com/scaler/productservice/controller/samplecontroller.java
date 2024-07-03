package com.scaler.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class samplecontroller {
    @GetMapping("/hello/{name}")
    public String sayhello(@PathVariable String name) {
        return "hello "+name;
    }
    @GetMapping("/bye")
    public String saybye(){
        return "bye";
    }
}
