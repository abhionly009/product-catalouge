package com.agh.product_catalouge.controller;

import com.agh.product_catalouge.entity.Product;
import com.agh.product_catalouge.entity.ProductDTOV1;
import com.agh.product_catalouge.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/add")
    public ResponseEntity<Product> createProduct( @Valid @RequestBody ProductDTOV1 product){
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body( productService.getAllProducts());
    }



    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products){
        return ResponseEntity.status(HttpStatus.CREATED).body( productService.addProductInBulk(products));
    }

    @GetMapping("/productDetails")
    public ResponseEntity<Optional<Product>> getProductDetails(@RequestParam long id ){

        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductDetails(id));

    }

    @GetMapping("/collection")
    public ResponseEntity<Page<Product>> getProductWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsWithPage(page,size,sortBy,direction));

    }
}
