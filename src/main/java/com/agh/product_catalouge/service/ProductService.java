package com.agh.product_catalouge.service;

import com.agh.product_catalouge.entity.Product;
import com.agh.product_catalouge.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> addProductInBulk(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Optional<Product> getProductDetails(long id){
       return productRepository.findById(id);
    }
}
