package com.agh.product_catalouge.service;

import com.agh.product_catalouge.entity.Product;
import com.agh.product_catalouge.entity.ProductDTOV2;
import com.agh.product_catalouge.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Product addProductOfDTO2(ProductDTOV2 dtos){
        Product product = new Product();
        product.setName(dtos.getProductName());
        product.setDescription(dtos.getDescription());
        product.setCategory(dtos.getCategory());
        product.setPrice(dtos.getPrice());
        product.setDiscount(dtos.getDiscount());

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

   public Page<Product> getProductsWithPage(int page, int size, String sortBy, String direction){

       Sort sort = direction.equalsIgnoreCase("desc")
               ? Sort.by(sortBy).descending()
               : Sort.by(sortBy).ascending();

       Pageable pageable = PageRequest.of(page,size,sort);
       Page<Product> allPageableProducts = productRepository.findAll(pageable);
       return allPageableProducts;
   }


    private Product mapV1ToEntity(Product dto) {
        Product p = new Product();
        p.setName(dto.getName()); // old → new mapping
        p.setPrice(dto.getPrice());
        p.setCategory(dto.getCategory());
        return p;
    }

    private Product mapV2ToEntity(ProductDTOV2 dto) {
        Product p = new Product();
        p.setName(dto.getProductName());
        p.setPrice(dto.getPrice());
        p.setCategory(dto.getCategory());
        return p;
    }
}
