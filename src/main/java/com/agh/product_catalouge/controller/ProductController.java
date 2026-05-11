package com.agh.product_catalouge.controller;

import com.agh.product_catalouge.entity.Product;
import com.agh.product_catalouge.service.ProductService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }


    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }



    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
       return productService.addProductInBulk(products);
    }

    @GetMapping("/productDetails")
    public Optional<Product> getProductDetails(@RequestParam long id ){

       return productService.getProductDetails(id);

    }



    @GetMapping("/collection")
    public Page<Product> getProductWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
            ){
       return productService.getProductsWithPage(page,size,sortBy,direction);

    }
}
