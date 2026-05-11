package com.agh.product_catalouge.controller;

import com.agh.product_catalouge.entity.Product;
import com.agh.product_catalouge.entity.ProductDTOV2;
import com.agh.product_catalouge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/product")
public class ProductControllerV2 {


    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public Product createProduct(@RequestBody ProductDTOV2 product){
        return productService.addProductOfDTO2(product);
    }

}
